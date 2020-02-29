package com.eval.interpreter.parser;

public class Token {
  private int start;
  private int end;
  private String elt;

  public Token(int start, int end, String elt) {
    this.start = start;
    this.end = end;
    this.elt = elt;
  }

  @Override
  public String toString() {
    return "Token{" +
      "start=" + start +
      ", end=" + end +
      ", elt='" + elt + '\'' +
      '}';
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public String getElt() {
    return elt;
  }
}
