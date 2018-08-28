/**
*Compare and display whether the values are bigger, equal or smaller.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*using scanner to give inputs.
**/
public final class BiggerEqualSmaller {
    /**
    *empty constructor.
    */
    private BiggerEqualSmaller() {
        //I am not using this constructor
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        int varA, varB;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value varA: ");
        varA = s.nextInt();
        System.out.println("Enter the value varB: ");
        varB = s.nextInt();
        if (varA > varB) {
            System.out.println("varA is bigger than varB");
        } else if (varA < varB) {
            System.out.println("varA is smaller than varB");
        } else {
            System.out.println("varA is equal to varB");
        }
    }
}
