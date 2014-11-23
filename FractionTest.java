/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // extend with extra tests
		//test division
	Fraction l = new Fraction(1, 2);
	Fraction m = new Fraction(1, 8);
	Fraction n = new Fraction(1, 4);
	if (!l.equals(m.divide(n))) System.out.println("Division failed");

		//test addition
	Fraction x = new Fraction(31, 40);
	Fraction y = new Fraction(2, 5);
	Fraction z = new Fraction(3, 8);
	if (!x.equals(y.add(z))) System.out.println("Addition Failed");

		//test subtraction
	Fraction a = new Fraction(3, 20);
	Fraction b = new Fraction(2, 5);
	Fraction c = new Fraction(1, 4);
	if (!a.equals(b.subtract(c))) System.out.println("Subtraction Failed");
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
