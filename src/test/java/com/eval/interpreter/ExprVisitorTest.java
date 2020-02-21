package com.eval.interpreter;


import static org.junit.Assert.assertEquals;


public class ExprVisitorTest {
  @org.junit.Test
  public void visit() throws VarNameNotFoundException {
    // (let (x 2) x)
    Expression expr = new LetExpr("x", new ConstExpr(2), new VarExpr("x"));
    ExprValue value = expr.Eval(new ExprVisitor(new EmptyEnv(), new EndCont()));
    assertEquals(((NumValue) value).getValue().intValue(), 2);
  }
}
