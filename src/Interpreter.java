import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Interpreter {
    private String program;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public Interpreter(String program) {
        log.debug(program);
        this.program = program;
    }

    public String evaluate() {
        log.debug("dummy");
        return "dummy";
    }

}
