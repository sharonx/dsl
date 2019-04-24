package Node;

public class AssignmentNode extends Node {
  private String identifier;
  private Node expression;

  public AssignmentNode(String identifier, Node expression) {
    this.identifier = identifier;
    this.expression = expression;
  }

  @Override
  public String toString() {
    return "AssignmentNode{" +
      "identifier='" + identifier + '\'' +
      ", expression=" + expression +
      '}';
  }
}
