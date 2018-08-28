
/**
*Power of a number.
*@author Swapnika
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class MySolution {
    /**
    *empty constructor.
    **/
    private MySolution() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        float a, b;
        float pow = 1;
        Scanner s = new Scanner(System.in);
        a = s.nextFloat();
        b = s.nextFloat();
        pow = power(a, b);
        System.out.println(pow);
    }
    /**
    *factorial function.
    *@param a is parameter for this function.
    *@param b is parameter for this function.
    *@return int
    **/
    public static float power(final float a, final float b) {
        if (b != 0) {
            return (a * power(a, b - 1));
        } else {
            return 1;
        }
    }
}

