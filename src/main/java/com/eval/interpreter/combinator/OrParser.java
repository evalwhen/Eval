package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public class OrParser extends Parser {
  private List<Parser> ps;

  public ParseResult parse(List<Token> toks, Continuation cont) {
    if (ps.isEmpty()) {
      ApplyCont v = new ApplyCont(new Failure(toks));
      return cont.accept(v);
    } else {
      return ps.remove(0).parse(toks, new OrCont(ps, toks, cont));
    }
  }

  public OrParser(List<Parser> ps) {
    this.ps = ps;
  }
}
