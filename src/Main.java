import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Interpreter interpreter;
        while (true) {
            System.out.print("calc> ");
            Scanner sc = new Scanner(System.in);
            String program = sc.nextLine();
            interpreter = new Interpreter(program);
            System.out.println(interpreter.evaluate());
        }
    }
}
