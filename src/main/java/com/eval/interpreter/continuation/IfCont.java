package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.Environment;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.value.ExprValue;

public class IfCont extends Continuation {
  private Expression then;
  private Expression els;
  private Environment currentEnv;
  private Continuation currentCont;

  public IfCont(Expression then, Expression els, Environment currentEnv, Continuation currentCont) {
    this.then = then;
    this.els = els;
    this.currentEnv = currentEnv;
    this.currentCont = currentCont;
  }

  public ExprValue apply(ContVistorI ask, ExprValue val) throws VarNameNotFoundException {
    return ask.visit(this, val);
  }

  public Expression getThen() {
    return then;
  }

  public Expression getEls() {
    return els;
  }

  public Environment getCurrentEnv() {
    return currentEnv;
  }

  public Continuation getCurrentCont() {
    return currentCont;
  }
}
