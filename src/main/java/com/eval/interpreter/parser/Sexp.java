package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.Continuation;
import com.eval.interpreter.combinator.OrParser;
import com.eval.interpreter.combinator.ParseResult;
import com.eval.interpreter.combinator.Parser;

import java.util.ArrayList;
import java.util.List;

public class Sexp extends Parser {

  public ParseResult parse(List<Token> toks, Continuation cont) {
    return newSexpP().parse(toks, cont);
  }

  private Parser newSexpP() {
    List<Parser> l = new ArrayList<Parser>();
    l.add(new Parens());
    l.add(new Atom());
    return new OrParser(l);
  }
}
