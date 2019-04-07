import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum TokenType {
    ADDITION(TokenType::isAddition, TokenType::ArithmeticOperationLength),
    SUBSTATION(TokenType::isSubtraction, TokenType::ArithmeticOperationLength),
    MULTIPLY(TokenType::isMultiply, TokenType::ArithmeticOperationLength),
    DIVIDE(TokenType::isDivide, TokenType::ArithmeticOperationLength),
    INTEGER(TokenType::isDigit, TokenType::IntegerLength);

    private Predicate<String> predicate;
    private Function<String, Integer> tokenLength;

    private static boolean isDigit(String s) {
        return Character.isDigit(s.charAt(0));
    }

    private static boolean isDivide(String s) {
        return s.charAt(0) == '/';
    }

    private static boolean isMultiply(String s) {
        return s.charAt(0) == '*';
    }

    private static boolean isAddition(String s) {
        return s.charAt(0) == '+';
    }

    private static boolean isSubtraction(String s) {
        return s.charAt(0) == '-';
    }

    private static Integer ArithmeticOperationLength(String s) {
        return 1;
    }


    private static Integer IntegerLength(String input) {
        int position = 0;
        while (position < input.length() &&  Character.isDigit(input.charAt(position)))
            position++;
        return position;
    }

    TokenType(Predicate<String> predicate, Function<String, Integer> supplier) {
        this.predicate = predicate;
        this.tokenLength = supplier;
    }

    public Boolean check(String input) {
        return predicate.test(input);
    }

    public Integer tokenLength(String input) {
        return tokenLength.apply(input);
    }
}
