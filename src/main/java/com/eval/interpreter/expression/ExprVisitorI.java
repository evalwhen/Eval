package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public interface ExprVisitorI {
  ExprValue visit(ConstExpr e) throws VarNameNotFoundException;
  ExprValue visit(VarExpr e) throws VarNameNotFoundException;
  ExprValue visit(DiffExpr e) throws VarNameNotFoundException;
  ExprValue visit(ZeroExpr e) throws VarNameNotFoundException;
  ExprValue visit(IfExpr e) throws VarNameNotFoundException;
  ExprValue visit(LetExp e) throws VarNameNotFoundException;
  ExprValue visit(CallExpr e) throws VarNameNotFoundException;
  ExprValue visit(LetRecExpr e);
  ExprValue visit(ProcedureExpr e) throws VarNameNotFoundException;
}
