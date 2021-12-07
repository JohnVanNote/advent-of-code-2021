package com.jvn.advent.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BingoTile {

  private final List<List<Number>> numbers;

  public static BingoTile create(List<List<Number>> numbers) {
    return new BingoTile(numbers);
  }

  public static BingoTile create(Integer[][] unmarkedNumbers) {
    final List<List<Number>> tileNumbers = new ArrayList<>();
    Arrays.stream(unmarkedNumbers).forEach(row -> {
      final List<Number> tileRow = new ArrayList<>();
      Arrays.stream(row).forEach(number -> tileRow.add(new Number(number)));
      tileNumbers.add(tileRow);
    });

    return create(tileNumbers);
  }

  public int calculateUnmarkedSum() {
    int unmarkedSum = 0;
    for (List<Number> row : numbers) {
      for (Number singleNumber : row) {
        if (!singleNumber.isMarked()) {
          unmarkedSum += singleNumber.getValue();
        }
      }
    }
    return unmarkedSum;
  }

  public void mark(int unmarkedNumber) {
    for (List<Number> row : numbers) {
      for (Number singleNumber : row) {
        if (singleNumber.getValue() == unmarkedNumber) {
          singleNumber.setMarked(true);
        }
      }
    }
  }

  public boolean hasWon() {
    return hasRowWin() || hasColumnWin();
  }

  private boolean hasRowWin() {
    boolean hasWon = false;
    for (List<Number> row : numbers) {
      boolean columnWin = true;
      for (Number singleNumber : row) {
        columnWin = columnWin && singleNumber.isMarked();
      }
      hasWon = hasWon || columnWin;
    }
    return hasWon;
  }

  private boolean hasColumnWin() {
    boolean hasWon = false;
    final int columnsSize = numbers.get(0).size();

    for (int i = 0; i < columnsSize; i++) {
      boolean rowWin = true;
      for (List<Number> row : numbers) {
        rowWin = rowWin && row.get(i).isMarked();
      }
      hasWon = hasWon || rowWin;
    }

    for (List<Number> row : numbers) {
      boolean columnWin = true;
      for (Number singleNumber : row) {
        columnWin = columnWin && singleNumber.isMarked();
      }
      hasWon = hasWon || columnWin;
    }
    return hasWon;
  }


  @Getter
  @Setter
  @ToString
  @EqualsAndHashCode
  public static class Number {

    private final int value;
    private boolean marked = false;

    public Number(int value) {
      this.value = value;
    }

  }

}
