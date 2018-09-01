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
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     **/
    static boolean checkcomposite(final int n) {
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
    static void oddComposites(final int n) {
    // write your code here
        for (int i = 3; i <= n;) {
            i += 2;
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