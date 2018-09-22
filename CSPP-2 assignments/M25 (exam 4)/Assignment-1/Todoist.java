import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * array of tasks.
     */
    private Task[] tasks;
    /**
     * declaration of variable size.
     */
    private int size;
    /**
    *@variable TEN
    **/
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    Todoist() {
        tasks = new Task[TEN];
        size = 0;
    }
    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        try {
            tasks[size] = task;
            size++;
        } catch (Exception e) {
            resize();
            addTask(task);
        }
    }
    /**
     * method to change the size.
     */
    private void resize() {
        tasks = Arrays.copyOf(tasks, 2 * size);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
        String imp = "Not Important";
            String urge = "Not Urgent";
            if (tasks[i].important) {
                imp = "Important";
            }
            if (tasks[i].urgent) {
                urge = "Urgent";
            }
            str += tasks[i].title + ", " + tasks[i].assignedTo + ", "
              + tasks[i].timeToComplete + ", " + imp + ", "+ urge + ", "
              + tasks[i].status;
            str += "\n";
        }
        return str;
    }
    /**
     * Gets the next task.
     *
     * @param      name  The name
     *
     * @return     The next task.
     */
    public Task getNextTask(final String name) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].important && !tasks[i].urgent) {
                if (tasks[i].assignedTo.equals(name)
                    && tasks[i].status.equals("todo")) {
                    return tasks[i];
                }
            }
        }
        return null;
    }
    /**
     * Gets the next task.
     *
     * @param      name   The name
     * @param      count  The count
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String name, final int count) {
        Task[] noOfTasks = new Task[count];
        int num = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].assignedTo.equals(name)
                && tasks[i].status.equals("todo")) {
                if (tasks[i].important && !tasks[i].urgent) {
                    noOfTasks[num] = tasks[i];
                    num++;
                    if (num == count) {
                        break;
                    }
                }
            }
        }
        return noOfTasks;
    }
    /**
     * calculates total time.
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int time = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].status.equals("todo")) {
                time += tasks[i].timeToComplete;
            }
        }
        return time;
    }
}

