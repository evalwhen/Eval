package com.eval.interpreter.parser;

import java.util.ArrayList;

public class SeqCont extends Continuation {
  ArrayList<Parser> ps;
  String nodes;
  Continuation savedCont;

  public SeqCont(ArrayList<Parser> ps, String nodes, Continuation savedCont) {
    this.ps = ps;
    this.savedCont = savedCont;
    this.nodes = nodes;
  }

  ParseResult accept(ContVI ask) {
    return ask.visit(this);
  }

  public ArrayList<Parser> getPs() {
    return ps;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }
}
