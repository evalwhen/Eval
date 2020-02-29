package com.eval.interpreter.parser;

public interface ApplyContInterface {
  ParseResult visit(NotCont notCont);

  ParseResult visit(PrintCont printCont);

  ParseResult visit(SeqCont seqCont);

  ParseResult visit(OrCont orCont);

  ParseResult visit(AndCont andCont);

  ParseResult visit(StarCont starCont);

  ParseResult visit(TagCont tagCont);
}
