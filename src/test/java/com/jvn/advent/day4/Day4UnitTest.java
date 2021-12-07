package com.jvn.advent.day4;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day4UnitTest {

  private static final List<Integer> CALL_NUMBERS = ImmutableList
      .of(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1);

  private static final BingoTile TILE_ONE = BingoTile.create(new Integer[][]{
      {22, 13, 17, 11, 0},
      {8, 2, 23, 4, 24},
      {21, 9, 14, 16, 7},
      {6, 10, 3, 18, 5},
      {1, 12, 20, 15, 19}
  });

  private static final BingoTile TILE_TWO = BingoTile.create(new Integer[][]{
      {3, 15, 0, 2, 22},
      {9, 18, 13, 17, 5},
      {19, 8, 7, 25, 23},
      {20, 11, 10, 24, 4},
      {14, 21, 16, 12, 6}
  });

  private static final BingoTile TILE_THREE = BingoTile.create(new Integer[][]{
      {14, 21, 17, 24, 4},
      {10, 16, 15, 9, 19},
      {18, 8, 23, 26, 20},
      {22, 11, 13, 6, 5},
      {2, 0, 12, 3, 7}
  });

  private static final List<BingoTile> TILES = ImmutableList.of(TILE_ONE, TILE_TWO, TILE_THREE);

  private Day4 day4 = new Day4();

  @Test
  public void playBingo_example_exampleScore() {
    Assert.assertEquals(day4.playBingo(TILES, CALL_NUMBERS), 4512);
  }

  @Test
  public void playBingoBadly_example_exampleScore() {
    Assert.assertEquals(day4.playBingoBadly(TILES, CALL_NUMBERS), 1924);
  }

}
