package com.eval.interpreter.combinator;

public abstract class Continuation {
  //todo: accept return parse result;
  abstract ParseResult accept(ApplyContInterface ask);
}
