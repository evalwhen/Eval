package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.Environment;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.value.ExprValue;

public class LetCont extends Continuation {
  private String varName;
  private Expression letBody;
  private Environment env;
  private Continuation savedCont;


  public LetCont(String varName, Expression letBody, Environment env, Continuation cont) {
    this.varName = varName;
    this.letBody = letBody;
    this.env = env;
    this.savedCont = cont;
  }

  public ExprValue apply(ContVistorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public String getVarName() {
    return varName;
  }

  Expression getLetBody() {
    return letBody;
  }

  Environment getEnv() {
    return env;
  }

  Continuation getSavedCont() {
    return savedCont;
  }
}
