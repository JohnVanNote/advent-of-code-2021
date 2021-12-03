package com.jvn.advent.day3;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day3UnitTest {

  private static final List<String> EXAMPLE_DATA = ImmutableList.of(
      "00100",
      "11110",
      "10110",
      "10111",
      "10101",
      "01111",
      "00111",
      "11100",
      "10000",
      "11001",
      "00010",
      "01010"
  );

  private final Day3 day3 = new Day3();

  @Test
  public void calculateBinaryDiagnostic_exampleData_calculatesCorrectly() {
    Assert.assertEquals(day3.calculateBinaryDiagnostic(EXAMPLE_DATA), 198);
  }

}
