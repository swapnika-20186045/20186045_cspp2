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
    private Solution() {
    //I am not using this function
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
    	int i, j = 1;
        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (i = 0; i <= n; i++) {
        	while (j < 0) {
        		j = j / 10;
        		if (j % 10 == 7) {
        			count++;
        		}
        	System.out.print(count);
        	}
        }
        
    }
}