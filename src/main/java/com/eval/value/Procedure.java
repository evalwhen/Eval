package com.eval.value;

import com.eval.expression.Expression;

class Procedure {
  private String varName;
  private Expression body;
//TODO:  Environment env;


  public Procedure(String varName, Expression body) {
    this.varName = varName;
    this.body = body;
  }

  @Override
  public String toString() {
    return "Procedure{" +
      "varName='" + varName + '\'' +
      ", body=" + body +
      '}';
  }
}
