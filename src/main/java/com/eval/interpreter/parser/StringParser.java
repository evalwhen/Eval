package com.eval.interpreter.parser;

public class StringParser extends Parser{
  String match;

  ParseResult parse(String toks, Continuation cont) {
    if (toks.length() < match.length()) {
      return cont.accept(new ContVisitor(new Failure(toks)));
    } else if (toks.startsWith(match)) {
      ContVisitor v = new ContVisitor(new Success(match, toks.substring(match.length())));
      return cont.accept(v);
    } else {
      return cont.accept(new ContVisitor(new Failure(toks)));
    }
  }

  public StringParser(String match) {
    this.match = match;
  }
}
