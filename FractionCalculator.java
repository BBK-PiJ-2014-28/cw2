// Fraction Calculator by Annabel Jump for Programming in Java coursework 2
import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args) {
        FractionCalculator calculator = new FractionCalculator();
        calculator.letsGo();
    }
    private void letsGo() {
        String storedOperand = "";
        boolean operandStored = false;
        boolean finished = false;
        Fraction fraction = new Fraction(0,1);

        // Welcome message
        System.out.println("Welcome to Annabel Jump's fraction calculator!");
        while (!finished) {
            System.out.println("Please enter your calculation:");

            //Scanner to receive user input
            Scanner sc = new Scanner(System.in);
            String inputCalculation = sc.nextLine();
            //check if quit command given, if not, evaluate
            if (inputCalculation.equals("q") || inputCalculation.equals("quit") || inputCalculation.equals("Q")) {
                System.out.print("Goodbye");
                finished = true;
            } else {
                calculator.evaluate(fraction, inputCalculation);
            }
        }
        //split up string to parts so as can evaluate
        String delims = "[ ]+";
        String[] inputs = inputCalculation.split(delims);


    }

}

