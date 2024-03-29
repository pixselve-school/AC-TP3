package expression;

import java.util.HashSet;
import java.util.Set;

public class Constante extends Expression {

  private final boolean b;

  public Constante(boolean b) {
    this.b = b;
  }

  public boolean evalue() throws RuntimeException {
    return b;
  }

  public Set<String> atomes() {
    return new HashSet<String>();
  }

  public Expression remplace(String s, boolean b) {
    return new Constante(this.b);
  }

  public Expression simplifier() {
    return this;
  }

  @Override
  public boolean estVrai() {
    return this.b;
  }

  @Override
  public boolean estFaux() {
    return !this.b;
  }

  @Override
  public String toString(String t) {
    return t + b;
  }
}
