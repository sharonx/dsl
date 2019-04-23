package Node;

import java.util.ArrayList;
import java.util.List;

public class ListNode extends Node {
  private List<Node> list;

  public ListNode() {
    this.list = new ArrayList<>();
  }

  public void add(Node n) {
    list.add(n);
  }

  @Override
  public String toString() {
    return "ListNode{" +
      "list=" + list +
      '}';
  }
}
