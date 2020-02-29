package com.eval.interpreter.parser;


import java.util.ArrayList;
import java.util.List;

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
      Leaf l = new Leaf(Ast.NodeType.token, rest.substring(0,1));
      ArrayList<Ast> list = new ArrayList<Ast>();
      list.add(l);
      this.v = new Success(list, rest.substring(1)); //success
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
      ArrayList<Parser > ps = new ArrayList<Parser>();
      ps.addAll(seqCont.getPs());
      ps.remove(0);

      List<Ast> list = new ArrayList<Ast>();
      list.addAll(seqCont.getNodes());
      list.addAll(((Success) v).result);

      return new SeqParser(ps, list).parse(((Success) v).rest, seqCont.savedCont);

    } else { // parse failure
      return seqCont.savedCont.accept(this);
    }
  }
}
