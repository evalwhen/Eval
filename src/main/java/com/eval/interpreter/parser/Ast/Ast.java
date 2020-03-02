package com.eval.interpreter.parser.Ast;

import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.parser.InvalidSyntaxException;

public abstract class Ast {
  public enum NodeType {varname, phantom, number, sexp, let, diff, binding, application}

  public abstract NodeType getType();
  public abstract Expression toExpr(AstVistor ask) throws InvalidSyntaxException;
}
