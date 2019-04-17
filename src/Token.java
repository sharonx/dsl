public class Token {
  private TokenTypes token;
  private String text;

  public Token(TokenTypes token, String text) {
    this.token = token;
    this.text = text;
  }

  public TokenTypes getToken() {
    return token;
  }

  public void setToken(TokenTypes token) {
    this.token = token;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "Token{" +
      "token=" + token +
      ", text='" + text + '\'' +
      '}';
  }

  public enum TokenTypes {
    STRING,
    IDENTIFIER,
    LEFT_PAREN,
    RIGHT_PAREN,
    SEMI_COLON,
    COMMA,
    EQUAL
  }
}