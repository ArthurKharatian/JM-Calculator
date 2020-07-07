import java.io.IOException;

public class Calculator {

    public Calculator() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.repeater();
    }
    public void repeater() throws IOException {while (true){new Operations().calculate();}}

}
