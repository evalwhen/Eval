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
    return env.findBinding(ask, e.varName);
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
    ExtendCont(new LetCont(e.varName, e.body, cont));
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

  private void ExtendCont(Continuation newCont) {
    cont = newCont;
  }
}
