package com.eval.interpreter.parser;

import com.eval.interpreter.expression.Expression;

public abstract class Ast {
  public enum NodeType {token, parens, number, sexp}

  public abstract NodeType getType();
  abstract Expression toExpr(AstVistor ask) throws InvalidSyntaxException;
}
