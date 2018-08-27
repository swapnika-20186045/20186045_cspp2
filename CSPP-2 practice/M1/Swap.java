/**
*Swap.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*using scanner to give inputs.
**/
public final class Swap {
    /**
    *empty constructor.
    **/
    private Swap() {
        //I am not using this constructor
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        int x, y, temp;
        Scanner s = new Scanner(System.in);
        System.out.println("enter the value x: ");
        x = s.nextInt();
        System.out.println("enter the value y: ");
        y = s.nextInt();
        temp = x;
        x = y;
        y = temp;
        System.out.println("Values in x:" + x);
        System.out.println("Values in y:" + y);
    }
}
