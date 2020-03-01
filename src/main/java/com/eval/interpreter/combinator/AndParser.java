package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Ast;
import com.eval.interpreter.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class AndParser extends Parser {
  List<Parser> ps;
  List<ParseResult> res;

  public ParseResult parse(List<Token> toks, Continuation cont) {
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

  private ParseResult getResLast() {
    if (this.res.isEmpty()) {
      return new Success(new ArrayList<Ast>(), new ArrayList<Token>());
    } else {
      return this.res.get(this.res.size() - 1);
    }
  }
}
