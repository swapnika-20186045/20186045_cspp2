import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : Swapnika
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private static final int HUNDRED = 100;
    /**
    *@variable HUNDRED
    **/
    private static final int FIFTY = 50;
    /**
    *@variable FIFTY
    **/
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
                                final int rows, final int columns) {

    // write ypur code here
    int[][] a1 = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (a[i][j] % HUNDRED > FIFTY) {
               a1[i][j] = (a[i][j] / HUNDRED) * HUNDRED + HUNDRED;
            } else {
                a1[i][j] = (a[i][j] / HUNDRED) * HUNDRED;
            }
        }
    }
    return a1;
}
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
