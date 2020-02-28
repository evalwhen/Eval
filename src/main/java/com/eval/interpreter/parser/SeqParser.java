package com.eval.interpreter.parser;

import java.util.ArrayList;

public class SeqParser extends Parser{
  ArrayList<Parser> ps;
  String Nodes;

  ParseResult parse(String toks, Continuation cont) {
    if (ps.isEmpty()) {
      ContVisitor v = new ContVisitor(new Success(Nodes, toks));
      return cont.accept(v);
    } else {
      return ps.get(0).parse(toks, new SeqCont(ps, Nodes, cont));
    }
  }

  public SeqParser(ArrayList<Parser> ps, String nodes) {
    this.ps = ps;
    this.Nodes = nodes;
  }
}
