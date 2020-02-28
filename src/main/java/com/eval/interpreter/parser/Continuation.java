package com.eval.interpreter.parser;

abstract class Continuation {
  //todo: accept return parse result;
  abstract ParseResult accept(ContVI ask);
}
