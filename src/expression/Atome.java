package expression;

import java.util.HashSet;
import java.util.Set;

public class Atome extends Expression {

  private String name;

  public Atome(String s) {
    this.name = new String(s);
  }

  public boolean evalue() throws RuntimeException {
    throw new RuntimeException("L'expression ne peut pas être évaluée car elle contient (au moins) l'atome " + name);
  }

  public Set<String> atomes() {
    Set<String> set = new HashSet<>();
    set.add(this.name);
    return set;
  }

  public Expression remplace(String s, boolean b) {
    if (this.name.equals(s)) {
      return new Constante(b);
    } else {
      return new Atome(this.name);
    }
  }

  public Expression simplifier() {
    return this;
  }

}
