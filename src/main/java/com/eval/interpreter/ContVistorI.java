package com.eval.interpreter;

// TODO: 使用范型 代替 ExprValue
interface ContVistorI {
  ExprValue visit(EndCont cont, ExprValue val);
  ExprValue visit(LetCont cont, ExprValue val);
}
