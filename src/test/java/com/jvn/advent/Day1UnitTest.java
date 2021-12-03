package com.jvn.advent;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day1UnitTest {

  private final Day1 day1 = new Day1();

  @Test
  public void numberOfDepthIncreases_standard_countsIncreases() {
    final List<Integer> depths = ImmutableList.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
    Assert.assertEquals(day1.numberOfDepthIncreases(depths) ,7);
  }

}
