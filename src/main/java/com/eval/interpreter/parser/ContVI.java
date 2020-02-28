package com.eval.interpreter.parser;

public interface ContVI {
  ParseResult visit(NotCont notCont);

  ParseResult visit(PrintCont printCont);

  ParseResult visit(SeqCont seqCont);
}
