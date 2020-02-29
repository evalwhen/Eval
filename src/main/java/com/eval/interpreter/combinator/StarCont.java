package com.eval.interpreter.combinator;

import java.util.List;

public class StarCont extends Continuation {
  private Parser p;
  private List<Ast> nodes;
  private Continuation savedCont;

  public StarCont(Parser p, List<Ast> nodes, Continuation savedCont) {
    this.p = p;
    this.nodes = nodes;
    this.savedCont = savedCont;
  }

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }

  public Parser getP() {
    return p;
  }

  public List<Ast> getNodes() {
    return nodes;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }
}
