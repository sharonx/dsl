package Parser;

import Node.*;
import Token.Token;
import Token.TokenTypes;

import java.util.LinkedList;

public class Parser {
  public Parser() {
  }

  public Node parse(LinkedList<Token> tokens) throws Exception {
    Node n = parseProgram(tokens);

    if (!tokens.isEmpty()) {
      throw new Exception("Can't parse");
    }

    return n;
  }

  public Node parseExpr(LinkedList<Token> tokens) throws Exception {
    if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.STRING) {
      return new StringNode(tokens.pollFirst().getText());
    }

    if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.IDENTIFIER) {
      String identifier = tokens.pollFirst().getText();

      if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.LEFT_PAREN) {
        tokens.pollFirst();

        if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.RIGHT_PAREN) {
          tokens.pollFirst();
          return new FunctionCallNode(identifier);
        }

        ListNode listNode = parseList(tokens);
        if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.RIGHT_PAREN) {
          tokens.pollFirst();
          return new FunctionCallNode(identifier, listNode);
        }
      }

      return new VariableNode(identifier);
    }

    throw new Exception("Can't parse");
  }

  public ListNode parseList(LinkedList<Token> tokens) throws Exception {
    ListNode listNode = new ListNode();
    listNode.add(parseExpr(tokens));

    while(!tokens.isEmpty() && tokens.peekFirst().getToken() == TokenTypes.COMMA) {
        tokens.pollFirst();
        listNode.add(parseExpr(tokens));
    }

    return listNode;
  }

  public Node parseAssignment(LinkedList<Token> tokens) throws Exception {
    if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.IDENTIFIER) {
      String identifier = tokens.pollFirst().getText();

      if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.EQUAL) {
        tokens.pollFirst();

        Node expression = parseExpr(tokens);
        return new AssignmentNode(identifier, expression);
      }
    }
    throw new Exception("Can't parse");
  }

  public Node parseStatement(LinkedList<Token> tokens) throws Exception {
    if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.STRING) {
      return parseExpr(tokens);
    }

    if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.IDENTIFIER) {
      Token id = tokens.pollFirst();

      if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.EQUAL) {
        tokens.push(id);
        return parseAssignment(tokens);
      }

      if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.LEFT_PAREN) {
        tokens.push(id);
        return parseExpr(tokens);
      }

      if (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.SEMI_COLON) {
        return new VariableNode(id.getText());
      }
    }

    throw new Exception("Can't parse");
  }

  public Node parseProgram(LinkedList<Token> tokens) throws Exception {
    ListNode list = new ListNode();
    list.add(parseStatement(tokens));
    while (tokens.peekFirst() != null && tokens.peekFirst().getToken() == TokenTypes.SEMI_COLON) {
      tokens.pollFirst();

      if (tokens.peekFirst() != null) {
        list.add(parseStatement(tokens));
      }
    }
    return list;
  }

}
