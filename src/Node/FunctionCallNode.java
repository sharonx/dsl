package Node;

public class FunctionCallNode extends Node{
  private String identifier;
  private ListNode args;

  public FunctionCallNode(String identifier) {
    this(identifier, null);
  }

  public FunctionCallNode(String identifier, ListNode args) {
    this.identifier = identifier;
    this.args = args;
  }

  @Override
  public String toString() {
    return "FunctionCallNode{" +
      "identifier='" + identifier + '\'' +
      ", args=" + args +
      '}';
  }
}
