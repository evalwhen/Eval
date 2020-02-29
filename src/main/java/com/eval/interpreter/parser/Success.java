package com.eval.interpreter.parser;

import java.util.List;

public class Success extends ParseResult {
  List<Ast> result;
  String rest;

  public Success(List<Ast> result, String rest) {
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
