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
        // sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
    *binary to decimal function.
    *@param s is parameter for this function.
    *@return string
    **/
    public static int binaryToDecimal(final String s) {
        int sum = 0, power = 1;
        for (int i = 0;i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum += Math.pow(2, s.length() - i -1);
            }
            // sum += ((int) (s.charAt(i)) - '0') * power;
            // power *= 2;
        }
        return sum;
    }
}
