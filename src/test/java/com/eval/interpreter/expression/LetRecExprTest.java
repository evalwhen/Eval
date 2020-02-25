package com.eval.interpreter.expression;

import com.eval.interpreter.continuation.EndCont;
import com.eval.interpreter.environment.EmptyEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LetRecExprTest {

  @Test
  public void eval() throws VarNameNotFoundException {
    // (letrec (f (lambda (x) (if (= x 0) 0 (- (f (- x 1)) -2)))) (f 4))
    Expression letRecExpr =
      new LetRecExpr("f", "x",
        new IfExpr(
          new ZeroExpr(new VarExpr("x")),
          new ConstExpr(0),
          new DiffExpr(
            new CallExpr(
              new VarExpr("f"),
              new DiffExpr(
                new VarExpr("x"),
                new ConstExpr(1))),
            new ConstExpr(-2))),
        new CallExpr(
          new VarExpr("f"),
          new ConstExpr(4)));

    ExprVisitor v = new ExprVisitor(new EmptyEnv(), new EndCont());
    NumValue val = (NumValue)letRecExpr.Eval(v);

    assertEquals(8,val.getValue().intValue());
  }
}