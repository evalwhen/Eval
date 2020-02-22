package com.eval.interpreter.expression;

import com.eval.interpreter.continuation.EndCont;
import com.eval.interpreter.environment.EmptyEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiffExprTest {

  @Test
  public void eval() throws VarNameNotFoundException {
        // (let (x 10) (- x 3))
    Expression letDiffExpr =
      new LetExp(
        "x",
        new ConstExpr(10),
        new DiffExpr(new VarExpr("x"), new ConstExpr(3)));
    NumValue letDiffExprV = (NumValue)letDiffExpr.Eval(new ExprVisitor(new EmptyEnv(), new EndCont()));
    assertEquals(7,letDiffExprV.getValue().intValue());
  }
}