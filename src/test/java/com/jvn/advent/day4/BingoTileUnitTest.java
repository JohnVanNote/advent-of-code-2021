package com.jvn.advent.day4;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BingoTileUnitTest {

  private static final Integer[][] TEST_UNMARKED_NUMBERS = new Integer[][]{
      {1, 2},
      {3, 4}
  };

  private static final BingoTile TEST_TILE = BingoTile.create(TEST_UNMARKED_NUMBERS);

  private BingoTile tileUnderTest;

  @BeforeMethod
  public void setup() {
    tileUnderTest = BingoTile.create(TEST_UNMARKED_NUMBERS);
  }

  @Test
  public void marked_numberDoesNotExist_noTileChange() {
    tileUnderTest.mark(5);
    Assert.assertEquals(TEST_TILE, tileUnderTest);
  }

  @Test
  public void marked_numberDoesExist_tileChange() {
    tileUnderTest.mark(3);
    Assert.assertNotEquals(TEST_TILE, tileUnderTest);
  }

  @Test
  public void hasWon_notAllMarked_false() {
    tileUnderTest.mark(1);
    tileUnderTest.mark(4);
    Assert.assertFalse(tileUnderTest.hasWon());
  }

  @Test
  public void hasWon_rowMarked_true() {
    tileUnderTest.mark(1);
    tileUnderTest.mark(2);
    Assert.assertTrue(tileUnderTest.hasWon());
  }

  @Test
  public void hasWon_columnMarked_true() {
    tileUnderTest.mark(1);
    tileUnderTest.mark(3);
    Assert.assertTrue(tileUnderTest.hasWon());
  }


}
