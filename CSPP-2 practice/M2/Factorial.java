/**
*Factorial of a number.
*@author Swapnika
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class Factorial {
    /**
    *empty constructor.
    **/
    private Factorial() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        int n;
        int fact = 1;
        Scanner s = new Scanner(System.in);
        System.out.println("enter the value n: ");
        n = s.nextInt();
        fact = factorial(n);
        System.out.println("factorial is: " + fact);
    }
    /**
    *factorial function.
    *@param n is parameter for this function.
    *@return int
    **/
    public static int factorial(final int n) {
        if (n != 0) {
            return (n * factorial(n - 1));
        } else {
            return 1;
        }
    }
}
