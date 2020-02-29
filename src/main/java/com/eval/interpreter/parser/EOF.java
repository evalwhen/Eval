package com.eval.interpreter.parser;

public class EOF extends ScannerResult{

  public EOF(Token tok, int next) {
    super(tok, next);
  }
}
