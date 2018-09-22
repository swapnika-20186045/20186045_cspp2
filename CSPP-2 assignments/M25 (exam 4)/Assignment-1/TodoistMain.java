import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
/**
 * Class for todoist.
 */

class Todoist {
	/**
	 * array of tasks.
	 */
	Task[] tasks;
	/**
	 * declaration of variable size.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	Todoist() {
		tasks = new Task[10];
		size = 0;
	}
	/**
	 * Adds a task.
	 *
	 * @param      task  The task
	 */
	public void addTask(Task task) {
		try{
			tasks[size] = task;
			size++;
		} catch (Exception e) {
			resize();
		}
	}
	/**
	 * method to change the size.
	 */
	private void resize() {
        tasks = Arrays.copyOf(tasks, 2 * size);
    }
}

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
	Task(String titlee, String assignedToo, int timeToCompletee,
		boolean importantt, boolean urgentt, String statuss) throws Exception {
		this.title = titlee;
		this.assignedTo = assignedToo;
		this.timeToComplete = timeToCompletee;
		this.important = importantt;
		this.urgent = urgentt;
		this.status = statuss;
		if (title.equals("")) throw new Exception("Title not provided");
	}
	public String toString() {
		String imp = "Not Important";
		String urge = "Not Urgent";
		if(important) imp = "Important";
		if(urgent) urge = "Urgent";
		String str = title + ", " + assignedTo + ", " + timeToComplete + ", " + imp + ", "+ urge + ", " + status;
		return str;
    }
}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                // case "add-task":
                //     testAddTask(todo, tokens);
                // break;
                // case "print-todoist":
                //     System.out.println(todo);
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
