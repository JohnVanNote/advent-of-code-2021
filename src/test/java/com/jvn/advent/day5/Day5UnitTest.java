package com.jvn.advent.day5;

import com.google.common.collect.ImmutableList;
import com.jvn.advent.Day5.Day5;
import com.jvn.advent.Day5.Line;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day5UnitTest {

  private static final List<Line> LINES = ImmutableList.of(
      Line.create(0, 9, 5, 9),
      Line.create(8, 0, 0, 8),
      Line.create(9, 4, 3, 4),
      Line.create(2, 2, 2, 1),
      Line.create(7, 0, 7, 4),
      Line.create(6, 4, 2, 0),
      Line.create(0, 9, 2, 9),
      Line.create(3, 4, 1, 4),
      Line.create(0, 0, 8, 8),
      Line.create(5, 5, 8, 2)
  );

  private final Day5 day5 = new Day5();

  @Test
  public void howManyOverlap_exampleLinesWithoutDiagonals_equalsExampleValue() {
    Assert.assertEquals(day5.howManyOverlap(LINES, 2, false), 5);
  }


  @Test
  public void howManyOverlap_exampleLinesWithDiagonals_equalsExampleValue() {
    Assert.assertEquals(day5.howManyOverlap(LINES, 2, true), 12);
  }

}
