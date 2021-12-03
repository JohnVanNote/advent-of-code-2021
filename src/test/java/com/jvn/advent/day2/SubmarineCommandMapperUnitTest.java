package com.jvn.advent.day2;

import com.jvn.advent.day2.SubmarineCommand.CommandType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmarineCommandMapperUnitTest {

  @Test(dataProvider = "commandStrings")
  public void mapFromString(String commandString, SubmarineCommand expectedCommand) {
    Assert.assertEquals(SubmarineCommandMapper.mapFromString(commandString), expectedCommand);
  }

  @DataProvider
  public static Object[][] commandStrings() {
    return new Object[][]{
        {"forward 4", SubmarineCommand.create(CommandType.FORWARD, 4)},
        {"down 8", SubmarineCommand.create(CommandType.DOWN, 8)},
        {"up 5", SubmarineCommand.create(CommandType.UP, 5)}
    };
  }

}
