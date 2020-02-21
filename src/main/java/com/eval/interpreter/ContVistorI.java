package com.eval.interpreter;

import com.eval.interpreter.Environment.VarNameNotFoundException;

// TODO: 使用范型 代替 ExprValue
interface ContVistorI {
  ExprValue visit(EndCont cont, ExprValue val);
  ExprValue visit(LetCont cont, ExprValue val) throws VarNameNotFoundException;
}
