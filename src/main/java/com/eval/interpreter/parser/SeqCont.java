package com.eval.interpreter.parser;

import java.util.ArrayList;
import java.util.List;

public class SeqCont extends Continuation {
  ArrayList<Parser> ps;
  List<Ast> nodes;
  Continuation savedCont;

  public SeqCont(ArrayList<Parser> ps, List<Ast> nodes, Continuation savedCont) {
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

  public List<Ast> getNodes() {
    return nodes;
  }
}
