package expression;

public class AtomeCoord extends Atome {

  private final int line;
  private final int column;

  public AtomeCoord(int line, int column) {
    super("x_" + line + "_" + column);
    this.line = line;
    this.column = column;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }

  @Override
  public Expression remplace(String s, boolean b) {
    if (this.name.equals(s)) {
      return new Constante(b);
    } else {
      return new AtomeCoord(this.line, this.column);
    }
  }
}
