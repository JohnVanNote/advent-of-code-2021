package com.jvn.advent.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {

  private static final char ONE = Bit.ONE.getBitValue();
  private static final char ZERO = Bit.ZERO.getBitValue();

  public int calculateBinaryDiagnostic(List<String> binaryData) {
    final StringBuilder gamma = new StringBuilder();
    final StringBuilder epsilon = new StringBuilder();

    final int binarySize = binaryData.get(0).length();
    final List<Integer> binaryCounter = initializeArray(0, binarySize);

    for (String bitString : binaryData) {
      for (int i = 0; i < bitString.length(); i++) {
        final char bit = bitString.charAt(i);
        final int upOrDown = bit == ONE ? 1 : -1;
        final Integer currentValue = binaryCounter.get(i);
        binaryCounter.set(i, currentValue + upOrDown);
      }
    }

    for (Integer counter : binaryCounter) {
      if (counter > 0) {
        gamma.append(ONE);
        epsilon.append(ZERO);
      } else if (counter < 0) {
        gamma.append(ZERO);
        epsilon.append(ONE);
      } else {
        throw new IllegalStateException();
      }
    }

    return binaryStringToInt(gamma.toString()) * binaryStringToInt(epsilon.toString());
  }

  public int calculateLifeSupportRating(List<String> binaryData) {
    return binaryStringToInt(calculateLifeSupportRatingForBit(binaryData, Bit.ONE)) * binaryStringToInt(calculateLifeSupportRatingForBit(binaryData, Bit.ZERO));
  }

  public String calculateLifeSupportRatingForBit(List<String> binaryData, Bit defaultBit) {
    final List<String> dataCopy = new ArrayList<>(binaryData);

    int position = 0;
    while (dataCopy.size() > 1) {
      final List<String> ones = new ArrayList<>();
      final List<String> zeroes = new ArrayList<>();

      for (final String bits : dataCopy) {
        final char binaryChar = bits.charAt(position);
        if (binaryChar == ONE) {
          ones.add(bits);
        } else {
          zeroes.add(bits);
        }
      }

      if (ones.size() >= zeroes.size()) {
        if (defaultBit == Bit.ONE) {
          dataCopy.removeAll(zeroes);
        } else {
          dataCopy.removeAll(ones);
        }
      } else {
        if (defaultBit == Bit.ONE) {
          dataCopy.removeAll(ones);
        } else {
          dataCopy.removeAll(zeroes);
        }
      }

      position++;
    }

    return dataCopy.get(0);
  }

  private List<Integer> initializeArray(int defaultValue, int size) {
    Integer[] integers = new Integer[size];
    Arrays.fill(integers, defaultValue);
    return Arrays.asList(integers);
  }

  private int binaryStringToInt(String string) {
    return Integer.parseInt(string, 2);
  }

  public static void main(String[] args) throws IOException {
    final Day3 day3 = new Day3();
    final String inputFilePath = "src/main/resources/day3/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> binaryData = lines.collect(Collectors.toList());
      System.out.println(String.format("The binary diagnostic is %s", day3.calculateBinaryDiagnostic(binaryData)));
      System.out.println(String.format("The life support rating is %s", day3.calculateLifeSupportRating(binaryData)));
    }
  }


}
