package com.eval.interpreter.combinator;

public class ParserEndCont extends Continuation {
  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }
}
