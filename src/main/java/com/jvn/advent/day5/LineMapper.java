package com.jvn.advent.day5;

import org.apache.commons.lang3.StringUtils;

public class LineMapper {

  public static Line fromString(String string) {
    String[] splitLine = StringUtils.split(StringUtils.replace(string, " -> ", ","), ",");
    return Line.create(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
  }

}
