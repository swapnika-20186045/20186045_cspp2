/**
*Quadratic roots of given numbers.
*@author Swapnika
**/
import java.util.Scanner;
/**
*used to take inputs.
**/
public final class Solution {
	/*
	Do not modify this main function.
	*/
	/**
    *empty constructor.
    **/
    private Solution() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	/**
    *Quadratic roots function.
    *@param a is parameter for this function.
    *@param b is parameter for this function.
    *@param c is parameter for this function.
    *@return int
    **/
    public static float rootsOfQuadraticEquation(final int a, final int b, final int c) {
    	double det = (b * b) - (4 * a * c);
    	double r1, r2;
        r1 = (-b + Math.sqrt(det)) / (2 * a);
        r2 = (-b - Math.sqrt(det)) / (2 * a);
        System.out.println(+r1 + " " +r2);
        return 0;
    }
}
