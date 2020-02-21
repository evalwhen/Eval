package com.eval.interpreter;

class Procedure {
  private String varName;
  private Expression body;
  Environment env;


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
}
