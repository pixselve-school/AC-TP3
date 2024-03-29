package utils;

public class Pair {
  private final int first;
  private final int second;

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pair pair = (Pair) o;

    if (first != pair.first) return false;
    return second == pair.second;
  }

  @Override
  public int hashCode() {
    int result = first;
    result = 31 * result + second;
    return result;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ')';
  }
}
