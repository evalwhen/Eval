package com.eval.interpreter.value;

import com.eval.interpreter.environment.Environment;
import com.eval.interpreter.expression.Expression;

public class Procedure {
  private String varName;
  private Expression body;
  private Environment env;


  public Procedure(String varName, Expression body, Environment env) {
    this.varName = varName;
    this.body = body;
    this.env = env;
  }

  @Override
  public String toString() {
    return "Procedure{" +
      "varName='" + varName + '\'' +
      ", body=" + body +
      '}';
  }

  public String getVarName() {
    return varName;
  }

  public Expression getBody() {
    return body;
  }

  public Environment getEnv() {
    return env;
  }
}
