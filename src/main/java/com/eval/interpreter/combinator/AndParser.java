package com.eval.interpreter.combinator;

import java.util.ArrayList;
import java.util.List;

public class AndParser extends Parser {
  List<Parser> ps;
  List<ParseResult> res;

  public ParseResult parse(String toks, Continuation cont) {
    if (ps.isEmpty()) {
      ApplyCont a = new ApplyCont(this.getResLast());
      return cont.accept(a);
    } else {
      return ps.remove(0).parse(toks, new AndCont(ps, res, toks, cont));
    }
  }

  public AndParser(List<Parser> ps, List<ParseResult> res) {
    this.ps = ps;
    this.res = res;
  }

  private void initRes() {
    this.res = new ArrayList<ParseResult>();
    this.res.add(new Success(new ArrayList<Ast>(), ""));
  }

  private ParseResult getResLast() {
    if (this.res.isEmpty()) {
      return new Success(new ArrayList<Ast>(), "");
    } else {
      return this.res.get(this.res.size() - 1);
    }
  }
}
