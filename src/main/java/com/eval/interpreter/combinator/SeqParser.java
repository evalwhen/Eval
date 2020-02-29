package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public class SeqParser extends Parser{
  private List<Parser> ps;
  private List<Ast> nodes;

  public ParseResult parse(List<Token> toks, Continuation cont) {
    if (ps.isEmpty()) {
      ApplyCont v = new ApplyCont(new Success(nodes, toks));
      return cont.accept(v);
    } else {
      return ps.get(0).parse(toks, new SeqCont(ps, nodes, cont));
    }
  }

  public SeqParser(List<Parser> ps, List<Ast> nodes) {
    this.ps = ps;
    this.nodes = nodes;
  }
}
