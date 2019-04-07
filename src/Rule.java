import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Rule {

    List<TokenType> data;
    boolean trimWhiteSpaces;
    Function<String, String> ruleCalculator;
    private static int position = 0;

    public final static Rule ADDITION_OPERATION = new Rule(new ArrayList<>(Arrays.asList(TokenType.INTEGER, TokenType.ADDITION, TokenType.INTEGER)),
            true,
            Rule::calculateAddition);

    private Rule(List<TokenType> data, boolean trimWhiteSpaces, Function<String, String> ruleCalculator) {
        this.data = Collections.unmodifiableList(data);
        this.trimWhiteSpaces = trimWhiteSpaces;
        this.ruleCalculator = ruleCalculator;
    }

    public static List<Rule> getRules() {
        return new ArrayList<>(Arrays.asList(ADDITION_OPERATION));
    }

    List<TokenType> getData(){
        return data;
    }

    @Override
    public String toString () {
        return "Rule = { " + data + " };";
    }

    public String getRuleResult(String program) {
        return ruleCalculator.apply(program);
    }

    private static String calculateAddition(String program) {
        position = 0;
        int leftOperand = getInteger(program);
        while (!Character.isDigit(program.charAt(position))) {
            position ++;
        }
        int rightOperand = getInteger(program);
        return Integer.toString(leftOperand + rightOperand);
    }

    private static int getInteger(String program) {
        int startPosition = position;
        while (position < program.length() && Character.isDigit(program.charAt(position))) {
            position ++;
        }
        return Integer.valueOf(program.substring(startPosition, position));
    }
}
