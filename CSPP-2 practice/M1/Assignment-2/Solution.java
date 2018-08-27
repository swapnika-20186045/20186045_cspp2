/**
*Area of Triangle.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*using scanner to give inputs.
**/
public final class Solution {
    /**
    *empty constructor.
    */
    private Solution() {
        //I am not using this constructor
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        // areaOfTriangle(base, height);
        System.out.println(0.5 * base * height);
    }
}

