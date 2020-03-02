package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;

import java.util.ArrayList;
import java.util.List;

public class Const extends Parser {
  public ParseResult parse(List<Token> toks, Continuation cont) {
    return newConstP().parse(toks, cont);
  }

  private Parser newConstP() {
    List<Parser> list = new ArrayList<Parser>();
    list.add(new NotParser(new Start()));
    list.add(new NotParser(new End()));
    list.add(new NumberParser());
    return new AndParser(list, new ArrayList<ParseResult>());
  }
}
