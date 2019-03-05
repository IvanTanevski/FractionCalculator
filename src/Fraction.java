import java.util.*;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        } else if (denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0);
    }

    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public String toString(){
        return numerator + "/" + denominator;
    }
    public double toDouble(){
        return (double)(numerator / denominator);
    }
    public Fraction add(Fraction other){
        Fraction newFrac = new Fraction(this.numerator*other.denominator+other.numerator*this.denominator,
                this.denominator*other.denominator);
        newFrac.toLowestTerms();
        return newFrac;
    }
    public Fraction substract(Fraction other){
        Fraction newFrac = new Fraction(this.numerator*other.denominator-other.numerator*this.denominator,
                this.denominator*other.denominator);
        newFrac.toLowestTerms();
        return newFrac;
    }
    public Fraction multiply(Fraction other) {
        Fraction newFrac = new Fraction(this.numerator*other.numerator, this.denominator*other.denominator);
        newFrac.toLowestTerms();
        return newFrac;
    }
    public Fraction divide(Fraction other){
        if (other.numerator == 0){
            throw new IllegalArgumentException();
        } else {
            Fraction newFrac = new Fraction(this.numerator * other.denominator,
                    other.numerator * this.denominator);
            newFrac.toLowestTerms();
            return newFrac;
        }
    }
    public boolean equals(Object other) {
        if (other instanceof Fraction){             //-instanceof --> true if 'other' it's instance of Fraction Object
            Fraction otherNew = (Fraction) other;   //Cast 'other' to Fraction
            otherNew.toLowestTerms();
            Fraction thisFrac = new Fraction(this.numerator, this.denominator);
            thisFrac.toLowestTerms();
            return thisFrac.numerator==otherNew.numerator && thisFrac.denominator==otherNew.denominator;
        }
        else {
            throw new InputMismatchException("Fraction expected");
        }
    }
    public static int gcd(int numerator, int denominator){
        while(numerator!=0&&denominator!=0){
            int reminder = numerator%denominator;
            numerator = denominator;
            denominator = reminder;
        }
        return numerator;
    }
    private void toLowestTerms(){
        int gcd = gcd(this.numerator, this.denominator);
        numerator=this.numerator/gcd;
        denominator=this.denominator/gcd;
    }
}
