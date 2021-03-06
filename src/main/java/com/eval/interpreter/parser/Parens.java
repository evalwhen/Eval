package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;
import com.eval.interpreter.parser.Ast.Ast;

import java.util.ArrayList;
import java.util.List;

public class Parens extends Parser {

  public ParseResult parse(List<Token> toks, Continuation cont) {
    return newParensP().parse(toks, cont);
  }

  protected List<Parser> sequence() {
    List<Parser> l = new ArrayList<Parser>();
    l.add(new Start());
    l.add(new StarParser(new Sexp(), new ArrayList<Ast>()));
    l.add(new End());
    return l;
  }

  protected Ast.NodeType resultType() {
    return Ast.NodeType.sexp;
  }

  private Parser newParensP() {
    return new TagParser(resultType(), new SeqParser(sequence(), new ArrayList<Ast>()));
  }
}
