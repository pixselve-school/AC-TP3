package expression;

import java.util.HashSet;
import java.util.Set;

public class Ou extends Expression {

  private Expression e1, e2;

  public Ou(Expression e1, Expression e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  public boolean evalue() throws RuntimeException {
    return e1.evalue() || e2.evalue();
  }

  public Set<String> atomes() {
    Set<String> s = new HashSet<String>();
    s.addAll(e1.atomes());
    s.addAll(e2.atomes());
    return s;
  }

  public Expression remplace(String s, boolean b) {
    return new Ou(e1.remplace(s, b), e2.remplace(s, b));
  }

  public Expression simplifier() {
    e1 = e1.simplifier();
    e2 = e2.simplifier();
    if (e1.estVrai() || e2.estVrai())
      return new Constante(true);
    if (e1.estFaux())
      return e2;
    if (e2.estFaux())
      return e1;
    return this;
  }

  @Override
  public String toString(String t) {
    return t + "(\n" + e1.toString(t + '\t') + "\n" + t + "|\n" + e2.toString(t + '\t') + "\n" + t + ")";
  }
}
