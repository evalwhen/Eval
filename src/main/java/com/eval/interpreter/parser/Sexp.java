package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;

import java.util.ArrayList;
import java.util.List;

public class Sexp extends Parser {

  public ParseResult parse(List<Token> toks, Continuation cont) {
    return newSexpP().parse(toks, cont);
  }

  private Parser newSexpP() {
    List<Parser> l = new ArrayList<Parser>();
//    l.add(new Parens());
//    l.add(new Atom());
    l.add(new Diff());
    l.add(new Var());
    l.add(new Const());
    l.add(new Let());
    l.add(new Application());
    return new OrParser(l);
  }
}
