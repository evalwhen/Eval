package com.eval.interpreter.expression;

import com.eval.interpreter.continuation.*;
import com.eval.interpreter.environment.*;
import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.value.ProcValue;
import com.eval.interpreter.value.Procedure;

public class ExprVisitor implements ExprVisitorI {
  private Environment env;
  EnvVistorI ask = new FindBinding();
  private Continuation cont;

  public ExprVisitor(Environment env, Continuation cont) {
    this.env = env;
    this.cont = cont;
  }

  protected ContVistorI newContVistor(ExprValue value) {
    return new ContApplyVisitor(value);

  }

  public ExprValue visit(ConstExpr e) throws VarNameNotFoundException {
    ContVistorI contVisitor = newContVistor(new NumValue(e.getN()));
    return cont.apply(contVisitor) ;
  }

  public ExprValue visit(VarExpr e) throws VarNameNotFoundException {
    ContVistorI contVistor = newContVistor(env.findBinding(ask, e.varName));
    return cont.apply(contVistor);
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

  public ExprValue visit(CallExpr e) throws VarNameNotFoundException {
    this.cont = new OperatorCont(e.getArgument(),this.env,this.cont);
    return e.getProcedure().Eval(this);
  }

  public ExprValue visit(LetRecExpr e) throws VarNameNotFoundException {
    ExprVisitor v = new ExprVisitor(
      new ExtendEnvRec(e.getProcName(),e.getVarName(),e.getProcBody(),this.env),
      this.cont
    );
    return e.getLetBody().Eval(v);
  }

  public ExprValue visit(ProcedureExpr e) throws VarNameNotFoundException {
    ContVistorI contVisitor = newContVistor(
      new ProcValue(new Procedure(e.getVarName(), e.getBody(), this.env)));
    return this.cont.apply(contVisitor);
  }
}
