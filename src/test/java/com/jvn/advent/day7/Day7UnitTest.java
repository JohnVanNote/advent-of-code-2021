package com.jvn.advent.day7;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day7UnitTest {

  private static final List<Integer> CRAB_POSITIONS = ImmutableList.of(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);

  private final Day7 day7 = new Day7();

  @Test
  public void howMuchFuel_example_example() {
    Assert.assertEquals(day7.howMuchFuel(CRAB_POSITIONS), 37);
  }

}
