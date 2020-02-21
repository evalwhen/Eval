package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public interface ExprVisitorI {
  ExprValue visit(ConstExpr e) throws VarNameNotFoundException;
  ExprValue visit(VarExpr e) throws VarNameNotFoundException;
  ExprValue visit(DiffExpr e);
  ExprValue visit(ZeroExpr e);
  ExprValue visit(IfExpr e);
  ExprValue visit(LetExp e) throws VarNameNotFoundException;
  ExprValue visit(CallExpr e);
  ExprValue visit(LetRecExpr e);
  ExprValue visit(ProcedureExpr e);
}
