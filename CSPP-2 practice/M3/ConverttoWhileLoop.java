/**
*Convert to while loop.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class ConverttoWhileLoop {
    /**
    *empty constructor.
    **/
    private ConverttoWhileLoop() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[]args) {
        int n = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value n : ");
        n = s.nextInt();
        int i = 2;
        while (i <= n) {
                System.out.print(i + "\n");
                i += 2;
            }
        System.out.println("GoodBye!");
    }
}
