package com.eval.interpreter;

import com.eval.interpreter.Environment.Environment;
import com.eval.interpreter.Environment.EnvVistorI;
import com.eval.interpreter.Environment.FindBinding;
import com.eval.interpreter.Environment.VarNameNotFoundException;

public class ExprVisitor implements ExprVisitorI {
  private Environment env;
  EnvVistorI ask = new FindBinding();

  private Continuation cont;
  private ContVistorI contAsk = new ContApplyVistor();

  ExprVisitor(Environment env, Continuation cont) {
    this.env = env;
    this.cont = cont;
  }

  public ExprValue visit(ConstExpr e) throws VarNameNotFoundException {
    return cont.apply(contAsk, new NumValue(e.getN())) ;
  }

  public ExprValue visit(VarExpr e) throws VarNameNotFoundException {
    return cont.apply(contAsk, env.findBinding(ask, e.varName));
  }

  public ExprValue visit(DiffExpr e) {
    return null;
  }

  public ExprValue visit(ZeroExpr e) {
    return null;
  }

  public ExprValue visit(IfExpr e) {
    return null;
  }

  //TODO: Remove VarNameNotFoundException
  public ExprValue visit(LetExpr e) throws VarNameNotFoundException {
    this.cont = new LetCont(e.varName, e.body, this.env, this.cont);
    return e.valExpr.Eval(this);
  }

  public ExprValue visit(CallExpr e) {
    return null;
  }

  public ExprValue visit(LetRecExpr e) {
    return null;
  }

  public ExprValue visit(ProcedureExpr e) {
    return null;
  }
}
