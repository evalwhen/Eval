package com.eval.interpreter;

public class Eval implements ExprVisitorI {
  Environment env;
  EnvironmentVisitorI ask = new FindBinding();

  Continuation cont;
  ContVistorI contAsk;

  public Eval(Environment env, Continuation cont) {
    this.env = env;
  }

  public ExprValue visit(ConstExpr e) {
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
    this.cont = new LetCont(e.varName, e.body, this);
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

  public void extendEnvironment(String varName, ExprValue val) {
    this.env = new ExtendEnv(varName, val, this.env);
  }
}
