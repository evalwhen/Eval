package com.eval.interpreter.parser;


import java.util.ArrayList;

public class ContVisitor implements ContVI {
  private ParseResult v;

  public ContVisitor(ParseResult failure) {
    this.v = failure;
  }

  public ParseResult visit(NotCont notCont) {
    // parse success
    if (v instanceof Success) {
      this.v = new Failure(((Success) v).rest); //failure
    } else { // parse failure
      String rest = ((Failure) v).rest;
      this.v = new Success(rest.substring(0,1), rest.substring(1)); //success
    }
    return notCont.getSavedCont().accept(this);
  }

  public ParseResult visit(PrintCont printCont) {
    System.out.println(v);
    return v;
  }

  public ParseResult visit(SeqCont seqCont) {
        // parse success
    if (v instanceof Success) {
      ArrayList<Parser> ps = seqCont.getPs();
      ps.remove(0);
      return new SeqParser(ps, ((Success) v).result + seqCont.nodes)
        .parse(((Success) v).rest, seqCont.savedCont);
    } else { // parse failure
      String rest = ((Failure) v).rest;
      return seqCont.savedCont.accept(this);
    }
  }
}
