package com.jvn.advent.day10;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day10 {

  private final static BiMap<Character, Character> MATCHING_CHARACTERS = ImmutableBiMap.of(
      '(', ')',
      '[', ']',
      '{', '}',
      '<', '>'
  );

  private static final Map<Character, Integer> POINT_KEY = ImmutableMap.of(
      ')', 3,
      ']', 57,
      '}', 1197,
      '>', 25137
  );

  private static final Map<Character, Integer> A_DIIFERENT_POINT_KEY_FOR_SOME_REASON = ImmutableMap.of(
      ')', 1,
      ']', 2,
      '}', 3,
      '>', 4
  );

  public int part1Answer(List<String> chunks) {
    int sum = 0;

    for (String chunk : chunks) {
      final Optional<Character> optionalCorruptedCharacter = findCorruptedCharacter(chunk);
      if (optionalCorruptedCharacter.isPresent()) {
        sum += POINT_KEY.get(optionalCorruptedCharacter.get());
      }
    }

    return sum;
  }

  public long part2Answer(List<String> chunks) {
    final List<Long> scores = new ArrayList<>();

    for (String chunk : chunks) {
      final Optional<Character> optionalCorruptedCharacter = findCorruptedCharacter(chunk);
      if (!optionalCorruptedCharacter.isPresent()) {
        final List<Character> incompleteCharacters = findIncompleteCharacters(chunk);
        long score = scoreIncompleteCharacters(incompleteCharacters);
        scores.add(score);
      }
    }

    Collections.sort(scores);
    return scores.get(scores.size() / 2);
  }

  private Optional<Character> findCorruptedCharacter(String chunk) {
    Optional<Character> corruptedCharacter = Optional.empty();

    final Stack<Character> openStack = new Stack<>();

    for (int i = 0; i < chunk.length(); i++) {
      char character = chunk.charAt(i);
      if (MATCHING_CHARACTERS.containsKey(character)) {
        openStack.push(character);
      } else {
        char openCharacter = openStack.pop();
        if (character != MATCHING_CHARACTERS.get(openCharacter)) {
          corruptedCharacter = Optional.of(character);
          break;
        }
      }
    }

    return corruptedCharacter;
  }

  private List<Character> findIncompleteCharacters(String incompleteChunk) {
    final List<Character> incompleteChars = new ArrayList<>();

    final Stack<Character> openStack = new Stack<>();

    for (int i = 0; i < incompleteChunk.length(); i++) {
      char character = incompleteChunk.charAt(i);
      if (MATCHING_CHARACTERS.containsKey(character)) {
        openStack.push(character);
      } else {
        openStack.pop();
      }
    }

    for (Character openChar : openStack) {
      incompleteChars.add(MATCHING_CHARACTERS.get(openChar));
    }

    Collections.reverse(incompleteChars);

    return incompleteChars;
  }

  private long scoreIncompleteCharacters(List<Character> incompleteCharacters) {
    long sum = 0;

    for (Character character : incompleteCharacters) {
      sum *= 5;
      sum += A_DIIFERENT_POINT_KEY_FOR_SOME_REASON.get(character);
    }

    return sum;
  }

  public static void main(String[] args) throws IOException {
    final Day10 day10 = new Day10();
    final String inputFilePath = "src/main/resources/day10/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> chunks = lines
          .collect(Collectors.toList());
      System.out.println(String.format("Part 1 Answer %d", day10.part1Answer(chunks)));
      System.out.println(String.format("Part 2 Answer %d", day10.part2Answer(chunks)));

    }
  }

}
