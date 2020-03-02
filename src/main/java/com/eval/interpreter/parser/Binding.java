package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.Parser;
import com.eval.interpreter.combinator.VarNameParser;
import com.eval.interpreter.parser.Ast.Ast;

import java.util.ArrayList;
import java.util.List;

public class Binding extends Parens {
  @Override
  protected List<Parser> sequence() {
    List<Parser> l = new ArrayList<Parser>();
    l.add(new Start());
    l.add(new Var());
    l.add(new Sexp());
    l.add(new End());
    return l;
  }

  @Override
  protected Ast.NodeType resultType() {
    return Ast.NodeType.binding;
  }
}
