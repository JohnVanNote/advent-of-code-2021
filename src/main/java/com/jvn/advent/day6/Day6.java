package com.jvn.advent.day6;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class Day6 {

  public long calculateTotalLanternFish(final List<Integer> fishAgesAtStart, final int numberOfDays) {
    long numberOfFish = 0;
    for (Integer fishAge : fishAgesAtStart) {
      numberOfFish += calculateLanternFishBoom(fishAge + 1, numberOfDays);
    }

    return numberOfFish;
  }

  private long calculateLanternFishBoom(final int startingFishAge, final int totalNumberOfDays) {
    long totalNumber = 1;
    int currentFishAge = startingFishAge;

    for (int i = 0; i < totalNumberOfDays; i++) {
      currentFishAge--;
      if (currentFishAge == 0) {
        final int remainingNumberOfDays = totalNumberOfDays - (i + 1);
        totalNumber += calculateLanternFishBoom(9, remainingNumberOfDays);
        currentFishAge = 7;
      }
    }

    return totalNumber;
  }

  public long calculateTotalLanternFishEfficient(final List<Integer> fishAgesAtStart, final int numberOfDays) {
    final List<Long> ages = Lists.newArrayList(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);

    for (Integer fishAgeAtStart : fishAgesAtStart) {
      ages.set(fishAgeAtStart, ages.get(fishAgeAtStart) + 1L);
    }

    for (int i = numberOfDays; i > 0; i--) {
      long numberOfFishThatMadeIt = ages.get(0);
      ages.set(0, ages.get(1));
      ages.set(1, ages.get(2));
      ages.set(2, ages.get(3));
      ages.set(3, ages.get(4));
      ages.set(4, ages.get(5));
      ages.set(5, ages.get(6));
      ages.set(6, ages.get(7) + numberOfFishThatMadeIt);
      ages.set(7, ages.get(8));
      ages.set(8, numberOfFishThatMadeIt);
    }

    long numberOfFish = 0;
    for (Long age : ages) {
      numberOfFish += age;
    }

    return numberOfFish;
  }

  public static void main(String[] args) throws IOException {
    final Day6 day6 = new Day6();
    final String inputFilePath = "src/main/resources/day6/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> lineInput = lines
          .collect(Collectors.toList());
      final List<Integer> initialFishAges = Arrays.stream(StringUtils.split(lineInput.get(0), ","))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      final int numberOfDaysOne = 80;
      final int numberOfDaysTwo = 256;
      System.out.println(String.format("There are %d fish after %d days", day6.calculateTotalLanternFish(initialFishAges, numberOfDaysOne), numberOfDaysOne));
      System.out.println(
          String.format("There are %d fish after %d days", day6.calculateTotalLanternFishEfficient(initialFishAges, numberOfDaysTwo), numberOfDaysTwo));
    }
  }

}
