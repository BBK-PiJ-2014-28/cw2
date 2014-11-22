/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
        return "" + getNumerator() + '/' + getDenominator();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction divide(Fraction other) {

        // instead of two step fraction flipping process, simplified to one step division
        int num = this.getNumerator() * other.getDenominator();
        int denom = this.getDenominator() * other.getNumerator();
        Fraction f = new Fraction(num, denom);
        return simplify(f);
    }

    public Fraction add(Fraction other) {

        /** easiest method of adding fractions - first numerator is multiplied by denominator of second fraction
        * then, second numerator multiplied by first denominator to achieve common denominator
         * finally two numerators added and simplified */
        int num = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
        int denom = this.getDenominator() * other.getDenominator();
        Fraction f = new Fraction(num, denom);
        return simplify(f);
     }

    public Fraction simplify(Fraction other) {
        //simplify fractions to store best result
        int lowestNum = 0;
        int lowestDenom = 0;
        int a = 2;
        while ((other.getDenominator() % a != 0) && (other.getNumerator() % a != 0)) {
            a++;
        }
        while ((other.getDenominator() % a == 0) && (other.getNumerator() % a == 0)) {
            lowestNum = other.getNumerator() / a;
            lowestDenom = other.getDenominator() / a;
        }
        return new Fraction(lowestNum, lowestDenom);
    }


    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
