/**
*print the number of 7's between 1 to n.
*@author Swapnika.
**/
import java.util.Scanner;
    /**
    Do not modify this main function.
    **/
public final class Solution {
    /**
    *empty constructor.
    **/
    private static final int SEVEN = 7;
    /**
    *@variable SEVEN
    **/
    private static final int TEN = 10;
    /**
    *@variable TEN
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
        int n = s.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % TEN == SEVEN) {
                    count++;
                }
                temp = temp / TEN;
            }
        }
        System.out.println(count);
    }
}
