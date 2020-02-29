package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;

import java.util.ArrayList;
import java.util.List;

public class Atom extends Parser {
  public ParseResult parse(String toks, Continuation cont) {
    return newAtomP().parse(toks, cont);
  }

  private Parser newAtomP() {
    List<Parser> list = new ArrayList<Parser>();
    list.add(new NotParser(new Start()));
    list.add(new NotParser(new End()));
    return new AndParser(list, new ArrayList<ParseResult>());
  }
}
