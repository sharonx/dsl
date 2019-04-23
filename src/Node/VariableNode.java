package Node;

public class VariableNode extends Node {
  private String name;

  public VariableNode(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "VariableNode{" +
      "name='" + name + '\'' +
      '}';
  }
}
