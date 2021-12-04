package com.jvn.advent.util;

public class AdventException extends RuntimeException {

  public AdventException() {
    super();
  }

  public AdventException(Throwable t) {
    super(t);
  }

  public AdventException(String message) {
    super(message);
  }

}
