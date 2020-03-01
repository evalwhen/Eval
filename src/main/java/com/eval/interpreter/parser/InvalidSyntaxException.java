package com.eval.interpreter.parser;

public class InvalidSyntaxException extends Throwable {
  public InvalidSyntaxException(String s) {
    super(s);
  }
}
