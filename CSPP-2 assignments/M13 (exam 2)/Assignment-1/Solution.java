import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Swapnika Vakacharla
 */
class Set {
    /**
    *@variable TEN
    **/
    private static final int TEN = 10;
    /**
     * constructor.
     */
    private int[] set;
    /**
     *variable initialization.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public Set() {
        set = new int[TEN];
        size = 0;
    }
    /**
     * size of Set.
     *
     * @return     int
     */
    public int size() {
        return size;
    }
    /**
     * checks whether the set contains the value or not.
     *
     * @param      item  The item
     *
     * @return     boolean
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == set[i]) {
                return true;
            }
        }
        return false;
    }
    /**
     * resize the array.
     */
    public void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "{}";
        }
        String s = "{";
        int i;
        for (i = 0; i < size - 1; i++) {
            s += set[i] + ", ";
        }
        s += set[i] + "}";
        return s;
    }
    /**
     * get the index of elements.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index >= 0 && index < size) {
            return set[index];
        }
        return -1;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     int
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * adds the elements.
     *
     * @param      value  The value
     */
    public void add(final int value) {
        if (size >= set.length) {
            resize();
        }
        set[size++] = value;
    }
    /**
     * Adds all.
     *
     * @param      newArray  The new array
     */
    public void add(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            if (contains(newArray[i]) == false) {
                add(newArray[i]);
            }
        }
    }
    /**
     * Return a Set that contains common elements of this set and given set.
     *
     * @param      newArray  The new set
     *
     * @return     Set
     */
    public Set intersection(final Set newArray) {
        Set value = new Set();
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (newArray.contains(get(i))) {
                int temp = (get(i));
                value.add(temp);
            }
        }
        if (value.size == 0) {
            return value;
        }
        return value;
    }
    /**
     * Return a Set with the items that are contained in given int array.
     *
     * @param      newArray  The value
     *
     * @return     Set
     */
    public Set retainAll(final int[] newArray) {
        Set value = new Set();
        for (int i = 0; i < newArray.length; i++) {
            if (contains(newArray[i])) {
                int temp = (get(indexOf(newArray[i])));
                value.add(temp);
            }
        }
        if (value.size == 0) {
            return value;
        }
        return value;
    }
    /**
     * Return a 2D array to represent the ordered pairs that results
     *from the cartesian product of this Set to the given Set.
     *
     * @param      newSet  The new set
     *
     * @return     int[][]
     */
    public int[][] cartesianProduct(final Set newSet) {
        int[][] matrix;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < newSet.size(); j++) {
            // System.out.print(set[i]+", "
            //                  + newSet[j]); 
            }
        }
        return null;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
