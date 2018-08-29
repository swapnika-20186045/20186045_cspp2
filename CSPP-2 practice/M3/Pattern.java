/**
*To print a pattern.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class Pattern {
    /**
    *empty constructor.
    **/
    private Pattern() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[]args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value n : ");
        n = s.nextInt();
        int i, j, num;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j + " ");
                // num++;
            }
            System.out.println();
        }
    }
}
