import java.util.Scanner;
/**
*returns the decimal value for the given binary string.
*@author Swapnika.
*/
public final class Solution {
    /**
    *empty constructor.
    **/
    // private static final double PIVALUE = 22 / 7.0;
    /**
    *@variable PIVALUE
    **/
    private Solution() {
        //I am not using this constructor
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String s = sc.nextLine();
            long res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
    *binary to decimal function.
    *@param s is parameter for this function.
    *@return string
    **/
    public static long binaryToDecimal(final String s) {
        long sum = 0, power = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += ((int) (s.charAt(i)) - '0') * power;
            power ^= 2;
        }
        return sum;
    }
}
