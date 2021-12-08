package com.jvn.advent.Day5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Line {

  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;

  public boolean isHorizontal() {
    return y1 == y2;
  }

  public boolean isVertical() {
    return x1 == x2;
  }

  public static Line create(int x1, int y1, int x2, int y2) {
    return new Line(x1, y1, x2, y2);
  }

}
