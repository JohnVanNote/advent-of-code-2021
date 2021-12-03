package com.jvn.advent.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {

  public int calculateBinaryDiagnostic(List<String> binaryData) {
    StringBuilder gamma = new StringBuilder();
    StringBuilder epsilon = new StringBuilder();

    final List<Integer> binaryCounter = new ArrayList<>();

    for (String bitString : binaryData) {
      if (binaryCounter.isEmpty()) {
        for (int i = 0; i < bitString.length(); i++) {
          binaryCounter.add(0);
        }
      }

      for (int i = 0; i < bitString.length(); i++) {
        final char bit = bitString.charAt(i);
        final int incrementorOrDecrementor = bit == '1' ? 1 : -1;
        final Integer currentValue = binaryCounter.get(i);
        binaryCounter.set(i, currentValue + incrementorOrDecrementor);
      }

    }

    for (Integer counter : binaryCounter) {
      if (counter > 0) {
        gamma.append(Bit.ONE.getBitValue());
        epsilon.append(Bit.ZERO.getBitValue());
      } else if (counter < 0) {
        gamma.append(Bit.ZERO.getBitValue());
        epsilon.append(Bit.ONE.getBitValue());
      } else {
        throw new IllegalStateException();
      }
    }

    return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
  }

  public static void main(String[] args) throws IOException {
    final Day3 day3 = new Day3();
    final String inputFilePath = "src/main/resources/day3/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> binaryData = lines.collect(Collectors.toList());
      System.out.println(String.format("The binary diagnostic is %s", day3.calculateBinaryDiagnostic(binaryData)));
    }
  }


}
