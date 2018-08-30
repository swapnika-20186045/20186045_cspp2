/**
*return true if 6 appears as either the first or last element in the array.
*@author Swapnika
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class FirstLast6 {
    /**
    *empty constructor.
    **/
    private static final int SIX = 6;
    /**
    *@variable PIVALUE
    **/
    private FirstLast6() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        /* Declaring array of n elements, the value
         * of n is provided by the user
         */
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int b = s.nextInt();
            a[i] = b;
        }
        if (a[0] == SIX || a[n - 1] == SIX) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
