package com.jvn.advent.day7;

import com.jvn.advent.util.AdventException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class Day7 {

  public int howMuchFuel(List<Integer> crabPositions) {
    final int maxPosition = crabPositions.stream()
        .max(Integer::compareTo)
        .orElseThrow(AdventException::new);

    final List<Integer> positionMap = new ArrayList<>();
    IntStream.range(0, maxPosition + 1).forEach(i -> positionMap.add(0));

    for (Integer crabPosition : crabPositions) {
      IntStream.range(0, maxPosition + 1).forEach(i -> {
        int currentPositionValue = positionMap.get(i);
        positionMap.set(i, currentPositionValue + Math.abs(i - crabPosition));
      });
    }

    return positionMap.stream()
        .min(Integer::compareTo)
        .orElseThrow(AdventException::new);
  }

  public static void main(String[] args) throws IOException {
    final Day7 day7 = new Day7();
    final String inputFilePath = "src/main/resources/day7/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> lineInput = lines
          .collect(Collectors.toList());
      final List<Integer> crabPositions = Arrays.stream(StringUtils.split(lineInput.get(0), ","))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      System.out.println(String.format("Optimum fuel is %d", day7.howMuchFuel(crabPositions)));
    }
  }

}
