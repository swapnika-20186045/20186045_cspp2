/**
*QuotientReminder.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*using scanner to give inputs.
**/
public final class QuotientReminder {
    /**
    *empty constructor.
    */
    private QuotientReminder() {
        //I am not using this constructor
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        int x, y;
        Scanner s = new Scanner(System.in);
        System.out.println("enter the value x: ");
        x = s.nextInt();
        System.out.println("enter the value y: ");
        y = s.nextInt();
        System.out.println("Quotient is:" + x / y);
        System.out.println("Reminder is:" + x % y);
    }
}
