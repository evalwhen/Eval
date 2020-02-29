package com.eval.interpreter.parser;

import java.util.ArrayList;
import java.util.List;

public class SeqParser extends Parser{
  ArrayList<Parser> ps;
  List<Ast> nodes;

  ParseResult parse(String toks, Continuation cont) {
    if (ps.isEmpty()) {
      ContVisitor v = new ContVisitor(new Success(nodes, toks));
      return cont.accept(v);
    } else {
      return ps.get(0).parse(toks, new SeqCont(ps, nodes, cont));
    }
  }

  public SeqParser(ArrayList<Parser> ps, List<Ast> nodes) {
    this.ps = ps;
    this.nodes = nodes;
  }
}
