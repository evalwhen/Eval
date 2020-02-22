package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

// TODO: 使用范型 代替 ExprValue
public interface ContVistorI {
  ExprValue visit(EndCont cont);
  ExprValue visit(LetCont cont) throws VarNameNotFoundException;
  ExprValue visit(ZeroCont cont) throws VarNameNotFoundException;
  ExprValue visit(DiffCont1 cont) throws VarNameNotFoundException;
  ExprValue visit(DiffCont2 diffCont2) throws VarNameNotFoundException;
  ExprValue visit(IfCont ifCont) throws VarNameNotFoundException;
}
