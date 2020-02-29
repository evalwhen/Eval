package com.eval.interpreter.combinator;

public abstract class Ast {
  public enum NodeType {token, parens, sexp}

  abstract NodeType getType();
}
