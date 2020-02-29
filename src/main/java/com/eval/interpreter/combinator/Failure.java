package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public class Failure extends ParseResult {
  List<Token> rest;

  public Failure(List<Token> toks) {
    this.rest = toks;
  }

  @Override
  public String toString() {
    return "Failure{" +
      "rest='" + rest + '\'' +
      '}';
  }
}
