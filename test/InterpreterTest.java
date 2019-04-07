import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterpreterTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testAddition() {
        Interpreter interpreter = getInterpreter("3 + 5");
        assertEquals("8", interpreter.evaluate());
    }

    private Interpreter getInterpreter(String program) {
        return new Interpreter(program);
    }

}