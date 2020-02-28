package com.eval.interpreter.parser;

public class Failure extends ParseResult {
  String rest;

  public Failure(String toks) {
    this.rest = toks;
  }

  @Override
  public String toString() {
    return "Failure{" +
      "rest='" + rest + '\'' +
      '}';
  }
}
