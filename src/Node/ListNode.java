package Node;

import java.util.ArrayList;
import java.util.List;

public class ListNode extends Node {
  private List<String> list;

  public ListNode() {
    this.list = new ArrayList<>();
  }

  public void add(String s) {
    list.add(s);
  }

  @Override
  public String toString() {
    return "ListNode{" +
      "list=" + list +
      '}';
  }
}
