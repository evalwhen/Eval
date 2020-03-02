package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Ast.Ast;
import com.eval.interpreter.parser.Ast.Leaf;
import com.eval.interpreter.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class StringParser extends Parser{
  String match;

  public ParseResult parse(List<Token> toks, Continuation cont) {
    if (toks.isEmpty()) {
      return cont.accept(new ApplyCont(new Failure(toks)));
    } else if (toks.get(0).getElt().startsWith(match)) {
      Leaf l;
      l = new Leaf(Ast.NodeType.varname, match);
      ArrayList<Ast> list = new ArrayList<Ast>();
      list.add(l);
      ApplyCont a = new ApplyCont(new Success(list, toks.subList(1, toks.size())));
      return cont.accept(a);
    } else {
      return cont.accept(new ApplyCont(new Failure(toks)));
    }
  }

  public StringParser(String match) {
    this.match = match;
  }


}
