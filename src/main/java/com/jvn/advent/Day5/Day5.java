package com.jvn.advent.Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day5 {

  public int howManyOverlap(List<Line> lines, int threshold, boolean withDiagonals) {
    final List<List<Integer>> grid = new ArrayList<>();
    for (Line line : lines) {
      final int x1 = line.getX1();
      final int x2 = line.getX2();
      final int y1 = line.getY1();
      final int y2 = line.getY2();

      if (line.isHorizontal()) {
        for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
          incrementGrid(grid, i, y1);
        }
      }

      if (line.isVertical()) {
        for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
          incrementGrid(grid, x1, i);
        }
      }

      if (line.is45Degrees() && withDiagonals) {
        final int xSign = x1 > x2 ? -1 : 1;
        final int ySign = y1 > y2 ? -1 : 1;
        for (int i = 0; i <= Math.max(y1, y2) - Math.min(y1, y2); i++) {
          incrementGrid(grid, x1 + (i * xSign), y1 + (i * ySign));
        }
      }


    }
    return score(grid, threshold);
  }

  private void incrementGrid(List<List<Integer>> grid, int x, int y) {
    final int neededVerticalSize = y + 1;
    final int verticalSize = grid.size();
    for (int i = 0; i < (neededVerticalSize - verticalSize); i++) {
      grid.add(new ArrayList<>());
    }

    final int neededHorizontalSize = x + 1;
    final int horizontalSize = grid.get(y).size();
    for (int i = 0; i < (neededHorizontalSize - horizontalSize); i++) {
      grid.get(y).add(0);
    }

    final int currentValue = grid.get(y).get(x);
    grid.get(y).set(x, currentValue + 1);
  }

  private int score(List<List<Integer>> grid, int threshold) {
    int score = 0;
    for (List<Integer> row : grid) {
      for (Integer cell : row) {
        if (cell >= threshold) {
          score++;
        }
      }
    }
    return score;
  }

  private void printGrid(List<List<Integer>> grid, Line line) {
    System.out.println("~~~~~~~~~");
    System.out.println("Line " + line);
    for (List<Integer> row : grid) {
      System.out.println(row);
    }
    System.out.println("~~~~~~~~~");

  }

  public static void main(String[] args) throws IOException {
    final Day5 day5 = new Day5();
    final String inputFilePath = "src/main/resources/day5/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<Line> lineInput = lines
          .map(LineMapper::fromString)
          .collect(Collectors.toList());
      System.out.println(String.format("%s overlap", day5.howManyOverlap(lineInput, 2, false)));
      System.out.println(String.format("%s overlap with diagonals", day5.howManyOverlap(lineInput, 2, true)));
    }
  }

}
