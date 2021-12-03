package com.jvn.advent.day3;

import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public enum Bit {
  ZERO(0),
  ONE(1);

  private final int bitValue;

  Bit(int bitValue) {
    this.bitValue = bitValue;
  }

  private static final Map<Integer, Bit> VALUE_MAP;

  static {
    final Map<Integer, Bit> valueMap = new HashMap<>();
    for (Bit bit : Bit.values()) {
      valueMap.put(bit.getBitValue(), bit);
    }
    VALUE_MAP = ImmutableMap.copyOf(valueMap);
  }
}
