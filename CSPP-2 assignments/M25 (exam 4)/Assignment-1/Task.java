import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for task.
 */
class Task {
    /**
     * declaration of variable title.
     */
    String title;
    /**
     * declaration of variable assignedTo.
     */
    String assignedTo;
    /**
     * declaration of variable timeToComplete.
     */
    int timeToComplete;
    /**
     * declaration of variable important.
     */
    boolean important;
    /**
     * declaration of variable urgent.
     */
    boolean urgent;
    /**
     * declaration of variable status.
     */
    String status;
    /**
     * Constructs the object.
     */
    Task() {
        //not used.
    }
    /**
     * Constructs the object.
     *
     * @param      titlee           The titlee
     * @param      assignedToo      The assigned too
     * @param      timeToCompletee  The time to completee
     * @param      importantt       The importantt
     * @param      urgentt          The urgentt
     * @param      statuss          The statuss
     */
    Task(final String titlee, final String assignedToo,
        final int timeToCompletee, final boolean importantt,
        final boolean urgentt, final String statuss) throws Exception {
        this.title = titlee;
        this.assignedTo = assignedToo;
        this.timeToComplete = timeToCompletee;
        this.important = importantt;
        this.urgent = urgentt;
        this.status = statuss;
        if (title.equals("")) throw new Exception("Title not provided");
        if (timeToComplete < 0) throw new Exception("Invalid timeToComplete "
            + timeToComplete);
        if (!status.equals("todo") && !status.equals("done"))
            throw new Exception("Invalid status " + status);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String imp = "Not Important";
        String urge = "Not Urgent";
        if (important) imp = "Important";
        if(urgent) urge = "Urgent";
        String str = title + ", " + assignedTo + ", " + timeToComplete + ", " + imp + ", "+ urge + ", " + status;
        return str;
    }
}