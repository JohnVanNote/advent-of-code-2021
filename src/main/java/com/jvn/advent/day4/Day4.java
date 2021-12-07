package com.jvn.advent.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

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

  public static void main(String[] args) throws IOException {
    final Day4 day4 = new Day4();
    final String inputFilePath = "src/main/resources/day4/input.txt";

    try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
      final List<String> bingoData = lines.collect(Collectors.toList());
      final List<Integer> callNumbers = Arrays.stream(bingoData.get(0).split(","))
          .map(Integer::parseInt)
          .collect(Collectors.toList());

      final List<BingoTile> tiles = new ArrayList<>();
      List<List<Integer>> bingoTileRaw = new ArrayList<>();
      for (int i = 2; i < bingoData.size(); i++) {
        final String line = bingoData.get(i);
        if (StringUtils.isBlank(line)) {
          tiles.add(BingoTile.createFromIntegers(bingoTileRaw));
          bingoTileRaw = new ArrayList<>();
        } else {
          final List<Integer> row = Arrays.stream(line.trim().split("\\s+"))
              .map(Integer::parseInt)
              .collect(Collectors.toList());
          bingoTileRaw.add(row);
        }
      }

      System.out.println(String.format("The bingo score is %s", day4.playBingo(tiles, callNumbers)));
    }
  }

}
