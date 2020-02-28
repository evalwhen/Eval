package com.eval.interpreter.parser;

public class Success extends ParseResult {
  String result;
  String rest;

  public Success(String result, String rest) {
    this.result = result;
    this.rest = rest;
  }

  @Override
  public String toString() {
    return "Success{" +
      "result='" + result + '\'' +
      ", rest='" + rest + '\'' +
      '}';
  }
}
