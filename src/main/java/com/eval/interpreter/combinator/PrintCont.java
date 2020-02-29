package com.eval.interpreter.combinator;

public class PrintCont extends Continuation{
  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }
}
