package com.jvn.advent.day4;

import java.util.List;

public class Day4 {

  public int playBingo(List<BingoTile> bingoTiles, List<Integer> callNumbers) {
    for (Integer callNumber : callNumbers) {
      for (BingoTile bingoTile : bingoTiles) {
        bingoTile.mark(callNumber);
        if (bingoTile.hasWon()) {
          return callNumber * bingoTile.calculateUnmarkedSum();
        }
      }
    }
    return -1;
  }

}
