/**
*Power of a number.
*@author Swapnika
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class Solution {
    /**
    *empty constructor.
    **/
    private Solution() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        int a, b;
        int pow = 1;
        Scanner s = new Scanner(System.in);
        System.out.println("enter the value a: ");
        a = s.nextInt();
        System.out.println("enter the value b: ");
        b = s.nextInt();
        pow = power(a, b);
        System.out.println("power is: " + pow);
    }
    /**
    *factorial function.
    *@param a is parameter for this function.
    *@param b is parameter for this function.
    *@return int
    **/
    public static int power(final int a, final int b) {
        if (b != 0) {
            return (a * power(a, b - 1));
        } else {
            return 1;
        }
    }
}
