package com.jvn.advent.day8;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class Day8 {

  public int howManyUniqueSymbols(List<String> lineInput) {
    int numberOfUniqueSymbols = 0;

    final int positionOfPipe = 10;
    final List<Integer> uniqueListSize = ImmutableList.of(2, 3, 4, 7);

    for (String line : lineInput) {
      final List<String> segments = ImmutableList.copyOf(StringUtils.split(line, " "));

      for (int i = 0; i < segments.size(); i++) {
        if (i > positionOfPipe) {
          final String segment = segments.get(i);
          if (uniqueListSize.contains(segment.length())) {
            numberOfUniqueSymbols++;
          }
        }
      }

    }

    return numberOfUniqueSymbols;
  }

  public int decode(List<String> lineInput) {
    int total = 0;

    for (String line : lineInput) {
      final List<String> allSegments = ImmutableList.copyOf(StringUtils.split(line, " "));
      final List<List<String>> splitInput = splitInput(allSegments);

      final List<String> inputSegments = splitInput.get(0);
      final List<String> resultSegments = splitInput.get(1);

      final BiMap<Set<Character>, Integer> decodeMapping = simpleDecodeMapLoad(inputSegments);

      int sum = 0;
      for (String segment : resultSegments) {
        final Set<Character> segmentSet = setString(segment);
        final Integer digit = decodeMapping.get(segmentSet);
        sum = (sum * 10) + digit;
      }
      total += sum;

    }

    return total;
  }


  private BiMap<Set<Character>, Integer> simpleDecodeMapLoad(List<String> segments) {
    final BiMap<Set<Character>, Integer> decodeMapping = HashBiMap.create();
    for (String segment : segments) {
      final Set<Character> segmentSet = setString(segment);
      final int segmentLength = segmentSet.size();

      if (segmentLength == 2) {
        decodeMapping.put(segmentSet, 1);
      } else if (segmentLength == 3) {
        decodeMapping.put(segmentSet, 7);
      } else if (segmentLength == 4) {
        decodeMapping.put(segmentSet, 4);
      } else if (segmentLength == 7) {
        decodeMapping.put(segmentSet, 8);
      }
    }

    for (String segment : segments) {
      final Set<Character> segmentSet = setString(segment);
      final int segmentLength = segmentSet.size();

      if (segmentLength == 6) {
        final Set<Character> fourSet = new HashSet<>(decodeMapping.inverse().get(4));
        fourSet.removeAll(segmentSet);

        final Set<Character> sevenSet = new HashSet<>(decodeMapping.inverse().get(7));
        sevenSet.removeAll(segmentSet);

        if (fourSet.isEmpty()) {
          decodeMapping.put(segmentSet, 9);
        } else if (sevenSet.isEmpty()) {
          decodeMapping.put(segmentSet, 0);
        } else {
          decodeMapping.put(segmentSet, 6);
        }
      }
    }

    for (String segment : segments) {
      final Set<Character> segmentSet = setString(segment);
      final int segmentLength = segmentSet.size();

      if (segmentLength == 5) {
        final Set<Character> oneSet = new HashSet<>(decodeMapping.inverse().get(1));
        oneSet.removeAll(segmentSet);

        if (oneSet.isEmpty()) {
          decodeMapping.put(segmentSet, 3);
        } else {
          final Set<Character> sixSet = new HashSet<>(decodeMapping.inverse().get(6));
          sixSet.removeAll(segmentSet);
          if (sixSet.size() == 1) {
            decodeMapping.put(segmentSet, 5);
          } else {
            decodeMapping.put(segmentSet, 2);
          }
        }
      }
    }

    return decodeMapping;
  }

  private Set<Character> setString(String string) {
    return string.chars()
        .mapToObj(e -> (char) e)
        .collect(Collectors.toSet());
  }

  private List<List<String>> splitInput(List<String> input) {
    final int positionOfPipe = 10;

    final List<String> inputs = new ArrayList<>();
    final List<String> results = new ArrayList<>();

    for (int i = 0; i < input.size(); i++) {
      if (i < positionOfPipe) {
        inputs.add(input.get(i));
      } else if (i > positionOfPipe) {
        results.add(input.get(i));
      }
    }

    return Arrays.asList(input, results);
  }

  public static void main(String[] args) throws IOException {
    final Day8 day8 = new Day8();
    final String inputFilePath = "src/main/resources/day8/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> lineInput = lines
          .collect(Collectors.toList());
      System.out.println(String.format("The number of unique symbols is %d", day8.howManyUniqueSymbols(lineInput)));
      System.out.println(String.format("The decode value is %d", day8.decode(lineInput)));
    }
  }

}
