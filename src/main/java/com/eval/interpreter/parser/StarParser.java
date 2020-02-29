package com.eval.interpreter.parser;

import java.util.List;

public class StarParser extends Parser{
  private Parser p;
  private List<Ast> nodes;

  public StarParser(Parser p, List<Ast> nodes) {
    this.p = p;
    this.nodes = nodes;
  }

  ParseResult parse(String toks, Continuation cont) {
    if (toks.length() == 0) {
      ApplyCont a = new ApplyCont(new Success(nodes, ""));
      return cont.accept(a);
    } else {
      return p.parse(toks, new StarCont(p, nodes, cont));
    }
  }

  public Parser getP() {
    return p;
  }

  public List<Ast> getNodes() {
    return nodes;
  }
}
