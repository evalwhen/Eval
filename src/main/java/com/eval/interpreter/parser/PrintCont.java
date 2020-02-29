package com.eval.interpreter.parser;

public class PrintCont extends Continuation{
  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }
}
