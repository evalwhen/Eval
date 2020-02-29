package com.eval.interpreter.parser;

import java.util.ArrayList;
import java.util.List;

public class Sexp extends Parser{

  ParseResult parse(String toks, Continuation cont) {
    return newSexpP().parse(toks, cont);
  }

  private Parser newSexpP() {
    List<Parser> l = new ArrayList<Parser>();
    l.add(new Parens());
    l.add(new Atom());
    return new OrParser(l);
  }
}
