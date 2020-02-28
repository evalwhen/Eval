package com.eval.interpreter.parser;

public class PrintCont extends Continuation{
  ParseResult accept(ContVI ask) {
    return ask.visit(this);
  }
}
