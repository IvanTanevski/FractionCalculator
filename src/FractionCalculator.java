import java.util.*;

public class FractionCalculator {

    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        introduction();

        while(true) {
            String operation = getOperation();
            Fraction frac1 = getFraction();
            Fraction frac2 = getFraction();

            Fraction result = new Fraction(1,1);
            String result2 = "";

            if (operation.equals("=")) {
                System.out.println(frac1+" "+operation+" "+frac2+" is "+frac1.equals(frac2));
            } else {
                if (operation.equals("+")){
                    result = frac1.add(frac2);
                } else if (operation.equals("-")) {
                    result = frac1.divide(frac2);
                } else if (operation.equals("*")) {
                    if(frac2.getDenominator()==0){
                        result2="Undefined";
                    } else {
                        result = frac1.multiply(frac2);
                    }
                } else if (operation.equals("/")) {
                    if(frac2.getDenominator()==0) {
                        result2="Undefined";
                    } else {
                        result=frac1.divide(frac2);
                    }
                }
            } if(!result2.equals("")) {
                System.out.println(frac1+" "+operation+" "+"0"+" = "+result2);
            } else if (result.getNumerator()%result.getDenominator()==0){
                System.out.println(frac1+" "+operation+" "+frac2+" = "+(result.getNumerator()/result.getDenominator()));
            } else{
                System.out.println(frac1+" "+operation+" "+frac2+" = "+result.toString());
            }
        }


    }
    public static void introduction() {
        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit)");
        System.out.println("Please enter your fractions in in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------------------------------------------");
    }
    public static String getOperation() {
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operation = input.nextLine();
        while(!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") &&
                !operation.equals("=") && !operation.equalsIgnoreCase("q")) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            operation = input.nextLine();
        }
        if(operation.equalsIgnoreCase("q")){
            System.exit(0);
        }
        return operation;
    }
    public static boolean validFraction(String fraction){
        boolean valid;
        if (fraction.startsWith("-")) {
            fraction = fraction.substring(1);
        }

        if (fraction.contains(" ")||fraction.contains("-")||fraction.charAt(fraction.indexOf("/")+1)==('0')) {
            valid=false;

        } else if (fraction.contains("/")) {
            fraction = fraction.replace("/", "");
        }

        if (fraction.matches("[0-9]+")){
            valid=true;
        }else{
            valid=false;
        }

        return valid;
    }
    public static Fraction getFraction() {
        System.out.print("Please enter a Fraction (a/b) or integer (a): ");
        String frac = input.nextLine();

        while(!validFraction(frac)){
            System.out.print("Invalid Fraction, Please enter (a/b) or (a), where a and b are integers and b is greater than zero: ");
            frac = input.nextLine();
        }

        int num;
        int den;
        if (frac.contains("/")) {
            num = Integer.parseInt(frac.substring(0, frac.indexOf("/")));
            den = Integer.parseInt(frac.substring(frac.indexOf("/")+1));
        } else {
            num = Integer.parseInt(frac);
            den = 1;
        }
        Fraction newFrac = new Fraction (num, den);
        return newFrac;
    }
}
