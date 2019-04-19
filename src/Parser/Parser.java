package Parser;

import Node.ListNode;
import Node.Node;
import Token.Token;
import Token.TokenTypes;

import java.util.List;
import java.util.ListIterator;

public class Parser {
  public Parser() {
  }

  public Node parseList(List<Token> tokens) throws Exception {
    ListIterator<Token> listIterator = tokens.listIterator();
    ListNode listNode = new ListNode();
    Token cur;

    while(listIterator.hasNext()) {
      cur = listIterator.next();
      if (cur.getToken() == TokenTypes.IDENTIFIER) {
        listNode.add(cur.getText());
      }
      if (listIterator.hasNext()) {
        cur = listIterator.next();
        if (cur.getToken() != TokenTypes.COMMA) {
          throw new Exception("Cannot parse");
        }
      }
    }

    return listNode;
  }
}
