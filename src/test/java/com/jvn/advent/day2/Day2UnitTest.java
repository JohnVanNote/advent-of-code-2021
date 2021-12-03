package com.jvn.advent.day2;

import com.google.common.collect.ImmutableList;
import com.jvn.advent.day2.SubmarineCommand.CommandType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day2UnitTest {

  private static final ImmutableList<SubmarineCommand> COMMANDS = ImmutableList.of(
      SubmarineCommand.create(CommandType.FORWARD, 5),
      SubmarineCommand.create(CommandType.DOWN, 5),
      SubmarineCommand.create(CommandType.FORWARD, 8),
      SubmarineCommand.create(CommandType.UP, 3),
      SubmarineCommand.create(CommandType.DOWN, 8),
      SubmarineCommand.create(CommandType.FORWARD, 2)
  );

  private final Day2 day2 = new Day2();

  @Test
  public void findSubmarinePosition_commands_standard() {
    Assert.assertEquals(day2.findSubmarinePosition(COMMANDS), 150);
  }

  @Test
  public void findComplexSubmarinePosition_commands_standard() {
    Assert.assertEquals(day2.findComplexSubmarinePosition(COMMANDS), 900);
  }

}
