package com.eval.interpreter;

public interface ExprVisitorI {
  ExprValue visit(ConstExpr e);
  ExprValue visit(VarExpr e) throws VarNameNotFoundException;
  ExprValue visit(DiffExpr e);
  ExprValue visit(ZeroExpr e);
  ExprValue visit(IfExpr e);
  ExprValue visit(LetExpr e) throws VarNameNotFoundException;
  ExprValue visit(CallExpr e);
  ExprValue visit(LetRecExpr e);
  ExprValue visit(ProcedureExpr e);
}
