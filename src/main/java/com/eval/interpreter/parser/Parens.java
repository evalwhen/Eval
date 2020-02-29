package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;

import java.util.ArrayList;
import java.util.List;

public class Parens extends Parser {

  public ParseResult parse(String toks, Continuation cont) {
    return newParensP().parse(toks, cont);
  }

  private Parser newParensP() {
    List<Parser> l = new ArrayList<Parser>();
    l.add(new Start());
    l.add(new StarParser(new Sexp(), new ArrayList<Ast>()));
    l.add(new End());

    return new TagParser(Ast.NodeType.sexp, new SeqParser(l, new ArrayList<Ast>()));
  }
}
