package com.jvn.advent.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day9 {

  public int lowPointSum(List<List<Integer>> heightmap) {
    final int rowLength = heightmap.size();
    final int columnLength = heightmap.get(0).size();

    int sum = 0;

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < columnLength; j++) {
        final int point = heightmap.get(i).get(j);
        final boolean isUpLow = (i - 1) < 0 || point < heightmap.get(i - 1).get(j);
        final boolean isDownLow = (i + 1) >= rowLength || point < heightmap.get(i + 1).get(j);
        final boolean isLeftLow = (j - 1) < 0 || point < heightmap.get(i).get(j - 1);
        final boolean isRightLow = (j + 1) >= columnLength || point < heightmap.get(i).get(j + 1);

        if (isUpLow && isDownLow && isLeftLow && isRightLow) {
          sum += point + 1;
        }
      }
    }

    return sum;
  }

  public int basinSizeProduct(List<List<Integer>> heightmap) {
    final int rowLength = heightmap.size();
    final int columnLength = heightmap.get(0).size();

    int sum = 0;

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < columnLength; j++) {
        final int point = heightmap.get(i).get(j);
        final boolean isUpLow = (i - 1) < 0 || point < heightmap.get(i - 1).get(j);
        final boolean isDownLow = (i + 1) >= rowLength || point < heightmap.get(i + 1).get(j);
        final boolean isLeftLow = (j - 1) < 0 || point < heightmap.get(i).get(j - 1);
        final boolean isRightLow = (j + 1) >= columnLength || point < heightmap.get(i).get(j + 1);

        if (isUpLow && isDownLow && isLeftLow && isRightLow) {
          sum += point + 1;
        }
      }
    }

    return sum;
  }

  public static void main(String[] args) throws IOException {
    final Day9 day9 = new Day9();
    final String inputFilePath = "src/main/resources/day9/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> allLines = lines
          .collect(Collectors.toList());

      final List<List<Integer>> heightMap = new ArrayList<>();
      for (String line : allLines) {
        heightMap.add(line.chars()
            .mapToObj(Character::getNumericValue)
            .collect(Collectors.toList()));
      }

      System.out.println(String.format("There risk level is %d", day9.lowPointSum(heightMap)));
    }
  }

}
