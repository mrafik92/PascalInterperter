public class Token<T> {
    private TokenType tokenType;
    private T value;

    public Token (TokenType tokenType, T value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }
}
