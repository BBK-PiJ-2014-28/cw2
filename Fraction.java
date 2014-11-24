/**
 * Created by keith (& edited by Annabel Jump) for the second coursework assignment.
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
        if(getDenominator() == 1) {
            return "" + getNumerator();
        }
        else {
            return "" + getNumerator() + '/' + getDenominator();
        }
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
        return new Fraction(num, denom);
    }

    public Fraction add(Fraction other) {
        /** easiest method of adding fractions - first numerator is multiplied by denominator of second fraction
        * then, second numerator multiplied by first denominator (to achieve fractions over common denominator)
         * finally two numerators added and through myGcd is simplified on creation of Fraction */
        int num = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
     }

    public Fraction subtract(Fraction other) {
        //method of subtracting fractions, similar to addition above
        int num = (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * this.getDenominator());
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction absValue(Fraction other) {
        //return the absolute value of a fraction
        if(other.getNumerator() < 0) {
            int num = other.getNumerator() * -1;
            int denom = other.getDenominator();
            return new Fraction(num, denom);
        }
        else {
            return other;
        }
    }

    public Fraction negate(Fraction other) {
        if(other.getNumerator() > 0) {
            int num = other.getNumerator() * -1;
            int denom = other.getDenominator();
            return new Fraction(num, denom);
        }
        else {
            return other;
        }
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
