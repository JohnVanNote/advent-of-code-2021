package com.jvn.advent;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.scene.shape.Path;

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

  public static void main(String[] args) throws IOException {
    final Day1 day1 = new Day1();
    final String inputFilePath = "src/main/resources/day1/input.txt";
    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      List<Integer> depths = lines
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      System.out.println(String.format("There are %d depth increases", day1.numberOfDepthIncreases(depths)));
    }
  }

}
