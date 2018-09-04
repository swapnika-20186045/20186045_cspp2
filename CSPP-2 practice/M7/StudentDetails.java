/**
*Student details.
*@author Swapnika.
**/
import java.util.Scanner;
/**
*using scanner to give inputs.
**/
public class StudentDetails {
    /**
     * details of student.
     */
    private String name;
    /**
     * student name.
     */
    private String rollno;
    /**
     * student roll number.
     */
    private double m1;
    /**
     * marks of subject 1.
     */
    private double m2;
    /**
     * marks of subject 2.
     */
    private double m3;
    /**
     * marks of subject 3.
     */
    private static final int THREE = 3;
    /**
    *@variable THREE
    **/
    private static final int TEN = 10;
    /**
    *@variable TEN
    **/
    /**
     * using this method.
     *
     * @param      name     The name
     * @param      rollnum  The rollnum
     * @param      m1       The m 1
     * @param      m2       The m 2
     * @param      m3       The m 3
     */
    public StudentDetails(final String name, final String rollnum,
                          final double m1, final double m2, final double m3) {
        this.name = name;
        this.rollno = rollnum;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
    /**
     * calculate gpa.
     *
     * @param      m1    The m 1
     * @param      m2    The m 2
     * @param      m3    The m 3
     *
     * @return     double
     */
    public static double gpa(final double m1, final double m2,
                             final double m3) {
        double gpa;
        gpa = (m1 + m2 + m3) / THREE;
        return (Math.floor(gpa * TEN)) / TEN;
    }
    /**
    *main function.
    *@param args is parameter for this function.
    **/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String rollno = sc.nextLine();
        double m1 = sc.nextDouble();
        double m2 = sc.nextDouble();
        double m3 = sc.nextDouble();
        System.out.println(gpa(m1, m2, m3));
    }
}
