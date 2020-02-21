package com.eval.interpreter.expression;

import com.eval.interpreter.continuation.EndCont;
import com.eval.interpreter.environment.EmptyEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExprVisitorTest {

  @Test
  public void visit() throws VarNameNotFoundException {
        // (let (x 2) x)
    Expression expr = new LetExp("x", new ConstExpr(2), new VarExpr("x"));
    ExprValue value = expr.Eval(new ExprVisitor(new EmptyEnv(), new EndCont()));
    assertEquals(((NumValue) value).getValue().intValue(), 2);
  }
}