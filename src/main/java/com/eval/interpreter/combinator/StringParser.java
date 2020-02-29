package com.eval.interpreter.combinator;

import java.util.ArrayList;

public class StringParser extends Parser{
  String match;

  public ParseResult parse(String toks, Continuation cont) {
    if (toks.length() < match.length()) {
      return cont.accept(new ApplyCont(new Failure(toks)));
    } else if (toks.startsWith(match)) {
      Leaf l = new Leaf(Ast.NodeType.token, match);
      ArrayList<Ast> list = new ArrayList<Ast>();
      list.add(l);
      ApplyCont a = new ApplyCont(new Success(list, toks.substring(match.length())));
      return cont.accept(a);
    } else {
      return cont.accept(new ApplyCont(new Failure(toks)));
    }
  }

  public StringParser(String match) {
    this.match = match;
  }
}
