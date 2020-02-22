package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

// TODO: 使用范型 代替 ExprValue
public interface ContVistorI {
  ExprValue visit(EndCont cont, ExprValue val);
  ExprValue visit(LetCont cont, ExprValue val) throws VarNameNotFoundException;
  ExprValue visit(ZeroCont cont, ExprValue val) throws VarNameNotFoundException;
  ExprValue visit(DiffCont1 cont, ExprValue val) throws VarNameNotFoundException;
  ExprValue visit(DiffCont2 diffCont2, ExprValue val) throws VarNameNotFoundException;
  ExprValue visit(IfCont ifCont, ExprValue val) throws VarNameNotFoundException;
}
