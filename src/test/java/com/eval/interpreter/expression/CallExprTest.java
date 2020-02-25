package com.eval.interpreter.expression;

import com.eval.interpreter.continuation.EndCont;
import com.eval.interpreter.environment.EmptyEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CallExprTest {

  @Test
  public void eval() throws VarNameNotFoundException {
    // ((lambda (x) (- x 2) 10)
    Expression callExpr = new CallExpr(
      new ProcedureExpr("x", new DiffExpr(new VarExpr("x"), new ConstExpr(2))),
      new ConstExpr(10)
    );

    ExprVisitor ev = new ExprVisitor(new EmptyEnv(), new EndCont());
    NumValue val = (NumValue)callExpr.Eval(ev);
    assertEquals(8,val.getValue().intValue());


  }

  @Test
  public void evalLetOverLambda() throws VarNameNotFoundException {
    // ( let (y 2) ((lambda (x) (- x y) 10))
    Expression callExpr2 =
      new LetExp("y", new ConstExpr(2),
        new CallExpr(
          new ProcedureExpr("x", new DiffExpr(new VarExpr("x"), new ConstExpr(2))),
          new ConstExpr(10)));

    ExprVisitor ev2 = new ExprVisitor(new EmptyEnv(), new EndCont());
    NumValue val2 = (NumValue)callExpr2.Eval(ev2);
    assertEquals(8,val2.getValue().intValue());
  }
}