package com.eval.interpreter.combinator;


import com.eval.interpreter.parser.Ast;
import com.eval.interpreter.parser.Leaf;
import com.eval.interpreter.parser.Node;
import com.eval.interpreter.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class ApplyCont implements ApplyContInterface {
  private ParseResult v;

  public ApplyCont(ParseResult failure) {
    this.v = failure;
  }

  public ParseResult visit(NotCont notCont) {
    // parse success
    if (v instanceof Success) {
      this.v = new Failure(((Success) v).rest); //failure
    } else { // parse failure
      List<Token> rest = notCont.getCurrent_toks();
      Leaf l = new Leaf(Ast.NodeType.token, rest.get(0).getElt());
      ArrayList<Ast> list = new ArrayList<Ast>();
      list.add(l);
      this.v = new Success(list, rest.subList(1, rest.size())); //success
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

  public ParseResult visit(OrCont orCont) {
    if (v instanceof Success) {
      return orCont.getSavedCont().accept(this);
    } else {
      return new OrParser(orCont.getPs()).parse(orCont.getToks(), orCont.getSavedCont());
    }
  }

  public ParseResult visit(AndCont andCont) {
    if (v instanceof Success) {
      List<ParseResult> res = new ArrayList<ParseResult>();
      res.addAll(andCont.getRes());
      res.add(v);
      return new AndParser(andCont.getPs(), res).parse(andCont.getToks(), andCont.getSavedCont());
    } else {
      return andCont.getSavedCont().accept(this);
    }
  }

  public ParseResult visit(StarCont starCont) {
    if (v instanceof Success) {
      List<Ast> nodes = new ArrayList<Ast>();
      nodes.addAll(starCont.getNodes());
      nodes.addAll(((Success) v).result);

      return new StarParser(starCont.getP(), nodes).parse(((Success) v).rest, starCont.getSavedCont());
    } else {
      ApplyCont a = new ApplyCont(new Success(starCont.getNodes(), ((Failure) v).rest));
      return starCont.getSavedCont().accept(a);
    }
  }

  public ParseResult visit(TagCont tagCont) {
    if (v instanceof Success) {
      List<Ast> result =  new ArrayList<Ast>();
      for (Ast node : ((Success) v).result) {
        if (node.getType() != Ast.NodeType.parens) {
          result.add(node);
        }
      }

      List<Ast> list = new ArrayList<Ast>();
      list.add(new Node(tagCont.getType(), result));
      ApplyCont a = new ApplyCont(new Success(list, ((Success) v).rest));

      return tagCont.getCont().accept(a);
    } else {
      return tagCont.getCont().accept(this);
    }
  }
}
