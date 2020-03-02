package com.eval.interpreter.parser.Ast;

import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.parser.Ast.Leaf;
import com.eval.interpreter.parser.Ast.Node;
import com.eval.interpreter.parser.InvalidSyntaxException;

public interface AstVistor {
  Expression visit(Node n) throws InvalidSyntaxException;
  Expression visit(Leaf l) throws InvalidSyntaxException;
}
