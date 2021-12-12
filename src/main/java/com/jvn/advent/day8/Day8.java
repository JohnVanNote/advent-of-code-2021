package com.jvn.advent.day8;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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

  public static void main(String[] args) throws IOException {
    final Day8 day8 = new Day8();
    final String inputFilePath = "src/main/resources/day8/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> lineInput = lines
          .collect(Collectors.toList());
      System.out.println(String.format("The number of unique symbols is %d", day8.howManyUniqueSymbols(lineInput)));
    }
  }

}
