package Node;

public class StringNode extends Node {
  private String str;

  public StringNode(String str) {
    this.str = str;
  }

  @Override
  public String toString() {
    return "StringNode{" +
      "str='" + str + '\'' +
      '}';
  }
}
