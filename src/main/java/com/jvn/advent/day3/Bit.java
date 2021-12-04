package com.jvn.advent.day3;

import lombok.Getter;

@Getter
public enum Bit {
  ZERO('0'),
  ONE('1');

  private final char bitValue;

  Bit(char bitValue) {
    this.bitValue = bitValue;
  }

}
