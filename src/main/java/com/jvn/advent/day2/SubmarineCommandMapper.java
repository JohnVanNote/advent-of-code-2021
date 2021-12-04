package com.jvn.advent.day2;

import com.jvn.advent.day2.SubmarineCommand.CommandType;
import org.apache.commons.lang3.StringUtils;

public class SubmarineCommandMapper {

  public static SubmarineCommand mapFromString(String stringCommand) {
    String[] split = StringUtils.split(stringCommand, " ");
    return SubmarineCommand.create(CommandType.fromMoniker(split[0]), Integer.parseInt(split[1]));
  }

}
