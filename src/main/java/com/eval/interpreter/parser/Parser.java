package com.eval.interpreter.parser;

public abstract class Parser {
  abstract ParseResult parse(String toks, Continuation cont);
}
