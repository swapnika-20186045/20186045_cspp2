/**
*Average of numbers in array.
*@author Swapnika
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class Average {
    /**
    *empty constructor.
    **/
    private Average() {
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
        double[] a = new double[n];
        double total = 0;

        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter Element No." + (i + 1) + ": ");
            a[i] = s.nextDouble();
            total = total + a[i];
        }
        double average = total / a.length;
        System.out.println(average);
    }
}
