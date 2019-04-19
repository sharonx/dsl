package Lexer;

import Token.Token;
import Token.TokenTypes;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
  public String input;

  public Lexer(String input) {
    this.input = input;
  }

  public List parseInput() throws Exception {
    StringCharacterIterator iterator = new StringCharacterIterator(input);
    List<Token> tokens = new ArrayList<>();
    char current = iterator.current();
    while (current != CharacterIterator.DONE) {
      if (current == ' ' || current == '\n') {
        current = iterator.next();
      } else if (current == '=') {
        tokens.add(new Token(TokenTypes.EQUAL, "="));
        current = iterator.next();
      } else if (current == '(') {
        tokens.add(new Token(TokenTypes.LEFT_PAREN, "("));
        current = iterator.next();
      } else if (current == ')') {
        tokens.add(new Token(TokenTypes.RIGHT_PAREN, ")"));
        current = iterator.next();
      } else if (current == ',') {
        tokens.add(new Token(TokenTypes.COMMA, ","));
        current = iterator.next();
      } else if (current == ';') {
        tokens.add(new Token(TokenTypes.SEMI_COLON, ";"));
        current = iterator.next();
      } else if (current == '"') {
        current = parseString(tokens, iterator);
      } else if(current >= 'a' && current <= 'z') {
        current = parseIdentifier(tokens, iterator);
      } else {
        throw new Exception("Unidentifiable character: " + current);
      }
    }

    return tokens;
  }

  private char parseString(List<Token> tokens, StringCharacterIterator iterator) {
    String str = "";
    char cur = iterator.next();
    while (cur != '"') {
      str += cur;
      cur = iterator.next();
    }

    tokens.add(new Token(TokenTypes.STRING, str));
    cur = iterator.next();
    return cur;
  }

  private char parseIdentifier(List<Token> tokens, StringCharacterIterator iterator) {
    String str = "";
    char cur = iterator.current();
    while ((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z') || (cur >= '0' && cur <= '9')) {
      str += cur;
      cur = iterator.next();
    }

    tokens.add(new Token(TokenTypes.IDENTIFIER, str));
    return cur;
  }
}