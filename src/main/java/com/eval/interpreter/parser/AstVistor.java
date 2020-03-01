package com.eval.interpreter.parser;

import com.eval.interpreter.expression.Expression;

public interface AstVistor {
  Expression visit(Node n) throws InvalidSyntaxException;
  Expression visit(Leaf l);
}
