/**
*Add two matrices.
*@author Swapnika
**/
import java.util.Scanner;
/**
*used to take inputs.
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
    public static void main(String[] args) {
        int rows1, cols1, rows2, cols2;
        Scanner s = new Scanner(System.in);
        rows1 = s.nextInt();
        cols1 = s.nextInt();
        int a[][] = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                a[i][j] = s.nextInt();
            }
        }
            
        // for (int i = 0; i < rows1; i++) {
        //     for (int j = 0; j < cols1; j++) {
        //         System.out.print(a[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        rows2 = s.nextInt();
        cols2 = s.nextInt();
        int b[][] = new int[rows2][cols2];
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                b[i][j] = s.nextInt();
            }
        }
        // for (int i = 0; i < rows2; i++) {
        //     for (int j = 0; j < cols2; j++) {
        //         System.out.print(b[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        int c[][] = new int[rows2][cols2];
        if (rows1 == rows2 && cols1 == cols2) {
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    for (int k = 0; k < cols1; k++) {
                        c[i][j] = a[i][j] + b[i][j];
                    }
                }
            }
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println("");
                }
            } else {
                System.out.println("not possible");
            }
        }
    }
