package com.jvn.advent.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {

  public int numberOfDepthIncreases(List<Integer> depths) {
    int numberOfDepthIncreases = 0;
    for (int i = 0; i < depths.size() - 1; i++) {
      if (depths.get(i + 1) > depths.get(i)) {
        numberOfDepthIncreases++;
      }
    }
    return numberOfDepthIncreases;
  }

  public int numberOfSlidingDepthIncreases(List<Integer> depths) {
    int numberOfSlidingDepthIncreases = 0;
    for (int i = 0; i < depths.size() - 3; i++) {
      if (slidingDepthTotal(depths, i+1) > slidingDepthTotal(depths, i)) {
        numberOfSlidingDepthIncreases++;
      }
    }
    return numberOfSlidingDepthIncreases;
  }

  private int slidingDepthTotal(List<Integer> depths, int startingIndex) {
    return depths.get(startingIndex) + depths.get(startingIndex + 1) + depths.get(startingIndex + 2);
  }

  public static void main(String[] args) throws IOException {
    final Day1 day1 = new Day1();
    final String inputFilePath = "src/main/resources/day1/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<Integer> depths = lines
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      System.out.println(String.format("There are %d depth increases", day1.numberOfDepthIncreases(depths)));
      System.out.println(String.format("There are %d sliding depth increases", day1.numberOfSlidingDepthIncreases(depths)));

    }
  }

}
