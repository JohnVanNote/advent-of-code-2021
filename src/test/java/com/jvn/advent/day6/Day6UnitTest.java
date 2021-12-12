package com.jvn.advent.day6;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day6UnitTest {

  private final List<Integer> startingFish = ImmutableList.of(3, 4, 3, 1, 2);

  private final Day6 day6 = new Day6();

  @Test
  public void calculateTotalLanternFish_oneFish() {
    Assert.assertEquals(day6.calculateTotalLanternFish(ImmutableList.of(3), 18), 5L);
  }


  @Test
  public void calculateTotalLanternFish_twoFish() {
    Assert.assertEquals(day6.calculateTotalLanternFish(ImmutableList.of(3, 4), 18), 9L);
  }

  @Test
  public void calculateTotalLanternFish_redFish() {
    Assert.assertEquals(day6.calculateTotalLanternFish(startingFish, 18), 26L);
  }

  @Test
  public void calculateTotalLanternFish_blueFish() {
    Assert.assertEquals(day6.calculateTotalLanternFish(startingFish, 80), 5934L);
  }

  @Test
  public void calculateTotalLanternFishEfficient_oneFish() {
    Assert.assertEquals(day6.calculateTotalLanternFishEfficient(ImmutableList.of(3), 18), 5L);
  }

  @Test
  public void calculateTotalLanternFishEfficient_twoFish() {
    Assert.assertEquals(day6.calculateTotalLanternFishEfficient(ImmutableList.of(3, 4), 18), 9L);
  }

  @Test
  public void calculateTotalLanternFishEfficient_redFish() {
    Assert.assertEquals(day6.calculateTotalLanternFishEfficient(startingFish, 18), 26L);
  }

  @Test
  public void calculateTotalLanternFishEfficient_blueFish() {
    Assert.assertEquals(day6.calculateTotalLanternFishEfficient(startingFish, 80), 5934L);
  }

  @Test
  public void calculateTotalLanternFishEfficient_alotOfFish() {
    Assert.assertEquals(day6.calculateTotalLanternFishEfficient(startingFish, 256), 26984457539L);
  }

}
