// Fraction Calculator by Annabel Jump for Programming in Java coursework 2
import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args) {
        FractionCalculator calculator = new FractionCalculator();
        calculator.letsGo();
    }
    private void letsGo() {
        boolean finished = false;


        // Welcome message
        System.out.println("Welcome to Annabel Jump's fraction calculator!");
        System.out.println("Still not complete, but please check it out!");
        while (!finished) {
            System.out.println("Please enter your calculation:");
            Fraction fraction = new Fraction(0,1);
            //Scanner to receive user input
            Scanner sc = new Scanner(System.in);
            String inputCalculation = sc.nextLine();
            //check if quit command given, if not, evaluate
            if (inputCalculation.equals("q") || inputCalculation.equals("quit") || inputCalculation.equals("Q")) {
                System.out.print("Goodbye");
                finished = true;
            } else {
                fraction = evaluate(fraction, inputCalculation);
                System.out.println("Your current answer is: " + fraction);
            }
        }
        public Fraction evaluate(Fraction fraction, String inputString) {
            String storedOperator = "";
            boolean operatorStored = false;
            //split up string to parts so as can evaluate
            String delims = "[ ]+";
            String[] inputs = inputString.split(delims);
            for (int i = 0; i < inputs.length; i++) {
                if (anOperator(inputs[i])) {
                    storedOperator = inputs[i];
                    operatorStored = true;
                } else if {
            }

            public boolean anOperator(String s) {
                if (s.length() == 1) {
                        if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                            return true;
                        }
                } else {
                    return false;
                }
        }
        }

    }

}

