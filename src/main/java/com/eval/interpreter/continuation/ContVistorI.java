package com.eval.interpreter.continuation;

import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.environment.VarNameNotFoundException;

// TODO: 使用范型 代替 ExprValue
public interface ContVistorI {
  ExprValue visit(EndCont cont, ExprValue val);
  ExprValue visit(LetCont cont, ExprValue val) throws VarNameNotFoundException;
}
