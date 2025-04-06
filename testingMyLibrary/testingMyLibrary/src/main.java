import com.calculator.Calculator;

public class main {
    public static void main(String[] args) {
        System.out.println("Main");
        Calculator calc = new Calculator();
        System.out.println("Add: " + calc.add(5, 3));
        System.out.println("Multiply: " + calc.multiply(2, 7));
    }
}
