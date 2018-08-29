/**
*Sum of N numbers.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class SumOfNNumbers {
    /**
    *empty constructor.
    **/
    private SumOfNNumbers() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[]args) {
        int n, sum = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value n : ");
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
