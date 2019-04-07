import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Interpreter {
    private String program;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private int position = 0;

    public Interpreter(String program) {
        log.debug(program);
        this.program = program;
    }


    public String evaluate() {
        boolean isRuleValid = false;
        Rule validRule = null;
        for (Rule rule : Rule.getRules()) {

            if (rule.trimWhiteSpaces) {
                program = removeWhiteSpaces(program);
                log.debug("trimming program = " + program);
            }

            for (TokenType tokenType : rule.getData()) {
                if (checkToken(tokenType)) {
                    log.debug("tokenType is " + tokenType.name());
                    movePosition(tokenType);
                } else {
                    break;
                }
                isRuleValid = true;
            }

            if (isRuleValid) {
                validRule = rule;
            }
        }

        if (isRuleValid) {
            log.debug("valid Rule is " + validRule);
            return validRule.getRuleResult(program);
        } else {
            return null;
        }

    }

    private boolean checkToken(TokenType tokenType) {
        return tokenType.check(program.substring(position));
    }

    private void movePosition(TokenType tokenType) {
        position += tokenType.tokenLength(program.substring(position));
        log.debug("new postion = " + position + ", token type = " + tokenType);
    }

    private String removeWhiteSpaces(String program) {
        return program.replaceAll("\\s+", "");
    }
}
