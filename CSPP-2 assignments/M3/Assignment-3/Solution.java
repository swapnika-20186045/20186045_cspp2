
import java.util.Scanner;
/*
    Do not modify this main function.
    */
public class Solution {
    /**
    *empty constructor.
    **/
    private static final int ONE = 1;
    /**
    *@variable ONE
    **/
    private Solution() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
    Need to write the gcd function and print the output.
    **/
    public static int gcd(final int n1, final int n2) {
        int min = 0;
        if (n1 < n2) {
            min = n1;
        } else {
            min = n2;
        }
        for (int i = min; i > ONE; i--) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }
        return ONE;
    }
}

