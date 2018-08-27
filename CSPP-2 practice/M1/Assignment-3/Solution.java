/**
*Convert degree to fahrenheit.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*using scanner to give inputs.
**/
public final class Solution {
    /**
    *empty constructor.
    */
    private Solution() {
        //I am not using this constructor
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        int a = 9;
        int b = 5;
        int d = 32;
        double c, f;
        Scanner s = new Scanner(System.in);
        c = s.nextDouble();
        f = c * a / b + d;
        System.out.println(f);
    }
}
