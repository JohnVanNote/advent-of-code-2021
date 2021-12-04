package com.jvn.advent.day2;

import com.jvn.advent.util.AdventException;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class SubmarineCommand {

  private final CommandType commandType;
  private final int value;

  public static SubmarineCommand create(CommandType commandType, int value) {
    return new SubmarineCommand(commandType, value);
  }

  public boolean isForward() {
    return commandType == CommandType.FORWARD;
  }

  public boolean isUp() {
    return commandType == CommandType.UP;
  }

  public boolean isDown() {
    return commandType == CommandType.DOWN;
  }

  @Getter
  public enum CommandType {
    FORWARD("forward"),
    UP("up"),
    DOWN("down");

    private final String moniker;

    CommandType(String moniker) {
      this.moniker = moniker;
    }

    public static CommandType fromMoniker(String moniker) {
      return Arrays.stream(values())
          .filter(value -> value.getMoniker().equals(moniker))
          .findFirst()
          .orElseThrow(AdventException::new);
    }

  }

}
