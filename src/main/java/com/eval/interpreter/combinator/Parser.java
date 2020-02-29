package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public abstract class Parser {
  public abstract ParseResult parse(List<Token> toks, Continuation cont);
}
