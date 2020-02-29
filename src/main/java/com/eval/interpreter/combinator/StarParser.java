package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class StarParser extends Parser{
  private Parser p;
  private List<Ast> nodes;

  public StarParser(Parser p, List<Ast> nodes) {
    this.p = p;
    this.nodes = nodes;
  }

  public ParseResult parse(List<Token> toks, Continuation cont) {
    if (toks.size() == 0) {
      ApplyCont a = new ApplyCont(new Success(nodes, new ArrayList<Token>()));
      return cont.accept(a);
    } else {
      return p.parse(toks, new StarCont(p, nodes, cont));
    }
  }

  public Parser getP() {
    return p;
  }

  public List<Ast> getNodes() {
    return nodes;
  }
}
