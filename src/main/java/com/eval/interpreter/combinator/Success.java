package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Ast;
import com.eval.interpreter.parser.Token;

import java.util.List;

public class Success extends ParseResult {
  List<Ast> result;
  List<Token> rest;

  public Success(List<Ast> result, List<Token> rest) {
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

  public List<Ast> getResult() {
    return result;
  }

  public List<Token> getRest() {
    return rest;
  }
}
