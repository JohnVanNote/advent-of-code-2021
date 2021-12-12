package com.jvn.advent.day9;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day9UnitTest {

  private static final List<List<Integer>> HEIGHT_MAP = ImmutableList.of(
      ImmutableList.of(2, 1, 9, 9, 9, 4, 3, 2, 1, 0),
      ImmutableList.of(3, 9, 8, 7, 8, 9, 4, 9, 2, 1),
      ImmutableList.of(9, 8, 5, 6, 7, 8, 9, 8, 9, 2),
      ImmutableList.of(8, 7, 6, 7, 8, 9, 6, 7, 8, 9),
      ImmutableList.of(9, 8, 9, 9, 9, 6, 5, 6, 7, 8)
  );

  private final Day9 day9 = new Day9();

  @Test
  public void lowPointSum_example_example() {
    Assert.assertEquals(day9.lowPointSum(HEIGHT_MAP), 15);
  }

  @Test
  public void basinSizeProduct_example_example() {
    Assert.assertEquals(day9.basinSizeProduct(HEIGHT_MAP), 1134);
  }

}
