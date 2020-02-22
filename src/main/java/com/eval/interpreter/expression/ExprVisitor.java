package com.eval.interpreter.expression;

import com.eval.interpreter.continuation.*;
import com.eval.interpreter.environment.Environment;
import com.eval.interpreter.environment.EnvVistorI;
import com.eval.interpreter.environment.FindBinding;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class ExprVisitor implements ExprVisitorI {
  private Environment env;
  EnvVistorI ask = new FindBinding();

  private Continuation cont;
  private ContVistorI contAsk = new ContApplyVisitor();

  public ExprVisitor(Environment env, Continuation cont) {
    this.env = env;
    this.cont = cont;
  }

  public ExprValue visit(ConstExpr e) throws VarNameNotFoundException {
    return cont.apply(contAsk, new NumValue(e.getN())) ;
  }

  public ExprValue visit(VarExpr e) throws VarNameNotFoundException {
    return cont.apply(contAsk, env.findBinding(ask, e.varName));
  }

  public ExprValue visit(DiffExpr e) throws VarNameNotFoundException {
    this.cont = new DiffCont1(e.getExp2(), this.env, this.cont);
    return e.getExp1().Eval(this);
  }

  public ExprValue visit(ZeroExpr e) throws VarNameNotFoundException {
    this.cont = new ZeroCont(this.cont);
    return e.getExpr().Eval(this);
  }

  public ExprValue visit(IfExpr e) throws VarNameNotFoundException {
    this.cont = new IfCont(e.getThen(), e.getEls(), this.env, this.cont);
    return e.getCond().Eval(this);
  }

  //TODO: Remove VarNameNotFoundException
  public ExprValue visit(LetExp e) throws VarNameNotFoundException {
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
