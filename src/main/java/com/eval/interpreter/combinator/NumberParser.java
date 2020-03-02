package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Ast.Ast;
import com.eval.interpreter.parser.Ast.Leaf;
import com.eval.interpreter.parser.Token;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class NumberParser extends Parser {
  public ParseResult parse(List<Token> toks, Continuation cont) {
    if (toks.isEmpty()) {
      ApplyCont a = new ApplyCont(new Failure(toks));
      return cont.accept(a);
    } else {
      Token t = toks.get(0);
      if (Util.isNumeric(t.getElt())) {
        Ast result = new Leaf(Ast.NodeType.number, t.getElt());
        List<Ast> list = new ArrayList<Ast>();
        list.add(result);
        ApplyCont a = new ApplyCont(new Success(list, toks.subList(1, toks.size())));
        return cont.accept(a);
      } else {
        ApplyCont a = new ApplyCont(new Failure(toks));
        return cont.accept(a);
      }
    }
  }
}
