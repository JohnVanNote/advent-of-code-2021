package com.jvn.advent.day2;

import com.jvn.advent.util.AdventException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {

  public int findSubmarinePosition(List<SubmarineCommand> commands) {
    int horizontal = 0;
    int depth = 0;

    for (SubmarineCommand command : commands) {
      final int value = command.getValue();
      if (command.isForward()) {
        horizontal += value;
      } else if (command.isDown()) {
        depth += value;
      } else if (command.isUp()) {
        depth -= value;
      } else {
        throw new IllegalStateException(String.format("Command %s not supported", command));
      }
    }

    return horizontal * depth;
  }

  public int findComplexSubmarinePosition(List<SubmarineCommand> commands) {
    int aim = 0;
    int horizontal = 0;
    int depth = 0;

    for (SubmarineCommand command : commands) {
      final int value = command.getValue();
      if (command.isForward()) {
        horizontal += value;
        depth += value * aim;
      } else if (command.isDown()) {
        aim += value;
      } else if (command.isUp()) {
        aim -= value;
      } else {
        throw new AdventException(String.format("Command %s not supported", command));
      }
    }

    return horizontal * depth;
  }

  public static void main(String[] args) throws IOException {
    final Day2 day2 = new Day2();
    final String inputFilePath = "src/main/resources/day2/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<SubmarineCommand> commands = lines
          .map(SubmarineCommandMapper::mapFromString)
          .collect(Collectors.toList());
      System.out.println(String.format("The submarine position is %s", day2.findSubmarinePosition(commands)));
      System.out.println(String.format("The complex submarine position is %s", day2.findComplexSubmarinePosition(commands)));
    }
  }

}
