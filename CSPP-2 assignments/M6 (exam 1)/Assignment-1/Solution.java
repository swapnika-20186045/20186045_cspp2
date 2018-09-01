import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : Swapnika
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private static final int THREE = 3;
    /**
    *@variable THREE
    **/
    private Solution() {
        //not used
    }
    /**
     * checks whether the given number is odd and composite.
     *
     * @param      n     n value
     * @return boolean
     **/
    static boolean checkcomposite(final int n) {
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     **/
    static void oddComposites(final int n) {
    // write your code here
        for (int i = THREE; i <= n; i += 2) {
            if (checkcomposite(i)) {
                System.out.println(i);
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
