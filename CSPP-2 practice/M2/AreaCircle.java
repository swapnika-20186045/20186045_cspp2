import java.util.Scanner;
/**
*Area of circle.
*@author Swapnika.
*/
public final class AreaCircle {
    /**
    *empty constructor.
    */
    private static final double PIVALUE = 22 / 7.0;
    /**
    *@variable PIVALUE
    **/
    private AreaCircle() {
        //I am not using this constructor
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println("Enter the radius:");
      double r = s.nextDouble();
      double a = area(r);
      System.out.println("Area of Circle is: " + a);
   }
   /**
    *Area function.
    *@param r is parameter for this function.
    *@return double
    **/
   public static double area(final double r) {
      return pi() * r * r;
    }
    /**
    *pi function.
    @return double
    **/
    public static double pi() {
        return PIVALUE;
    }

}


