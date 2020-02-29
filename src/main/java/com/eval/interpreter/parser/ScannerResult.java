package com.eval.interpreter.parser;

public class ScannerResult {
  private Token tok;
  private int next;

  public ScannerResult(Token tok, int next) {
    this.tok = tok;
    this.next = next;
  }

  public Token getTok() {
    return tok;
  }

  public int getNext() {
    return next;
  }
}
