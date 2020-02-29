package com.eval.interpreter.combinator;

import java.util.List;

public class SeqCont extends Continuation {
  List<Parser> ps;
  List<Ast> nodes;
  Continuation savedCont;

  public SeqCont(List<Parser> ps, List<Ast> nodes, Continuation savedCont) {
    this.ps = ps;
    this.savedCont = savedCont;
    this.nodes = nodes;
  }

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }

  public List<Parser> getPs() {
    return ps;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }

  public List<Ast> getNodes() {
    return nodes;
  }
}
