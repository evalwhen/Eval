package com.eval.interpreter.parser;

import java.util.ArrayList;

public class StringParser extends Parser{
  String match;

  ParseResult parse(String toks, Continuation cont) {
    if (toks.length() < match.length()) {
      return cont.accept(new ContVisitor(new Failure(toks)));
    } else if (toks.startsWith(match)) {
      Leaf l = new Leaf(Ast.NodeType.token, match);
      ArrayList<Ast> list = new ArrayList<Ast>();
      list.add(l);
      ContVisitor v = new ContVisitor(new Success(list, toks.substring(match.length())));
      return cont.accept(v);
    } else {
      return cont.accept(new ContVisitor(new Failure(toks)));
    }
  }

  public StringParser(String match) {
    this.match = match;
  }
}
