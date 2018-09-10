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
    Set() {
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
        return set[index];
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
        if (!contains(value)) {
            if (size >= set.length) {
                resize();
            }
            set[size++] = value;
            sortSet();
        }
    }
    /**
     * sort the set.
     */
    public void sortSet() {
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (set[i] < set[j]) {
                    int temp = set[j];
                    set[j] = set[i];
                    set[i] = temp;
                }
            }
        }
    }

    /**
     * Add the items given in the int array to the Set.
     *
     * @param      newArray  The new array
     */
    public void addAll(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            if (size + newArray.length >= set.length) {
                resize();
            }
            add(newArray[i]);
        }
    }

    /**
     * subset.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return     { description_of_the_return_value }
     */
    public Set subSet(final int fromElement, final int toElement) {
        Set s = new Set();
        if (fromElement > toElement) {
            System.out.println("Invalid Arguments to Subset Exception");
            return null;
        }
        for (int i = 0; i < size(); i++) {
            if (get(i) >= fromElement && get(i) < toElement) {
                s.add(set[i]);
            }
            // System.out.print(set[i]+" ");
        }
        // System.out.println();
        return s;
    }
    /**
     * Returns a array representation of the object.
     *
     * @return     String representation of the object.
     */
    public int[] toArray() {
        int[] temp = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.set[i];
        }
        return temp;
    }

    /**
     * print elements that are strictly less than toElement.
     * @param toElement   The last element
     * @return Set
     */
    public Set headSet(final int toElement) {
        if (toElement < get(0)) {
            return new Set();
        }
        return this.subSet(get(0), toElement);
    }
    /**
     * print the last element of the set.
     *
     * @return     { description_of_the_return_value }
     */
    public int last() {
        if (size <= 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        return this.get(size - 1);
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
        Scanner stdin = new Scanner(
            new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation
            //invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "print":
                System.out.println(s.toString());
                break;
            case "add":
                int[] intArray1 = intArray(tokens[1]);
                if (intArray1.length == 1) {
                    s.add(intArray1[0]);
                } else {
                    s.addAll(intArray1);
                }
                break;
            case "addAll":
                int[] intArray2 = intArray(tokens[1]);
                s.addAll(intArray2);
                break;
            case "subSet":
                int[] intArray3 = intArray(tokens[1]);
                int fromElement = intArray3[0];
                int toElement = intArray3[1];
                // System.out.println("subset");
                Set ss = s.subSet(fromElement, toElement);
                if (ss != null) {
                    System.out.println(ss.toString());
                }
                break;
            case "headSet":
                toElement = Integer.parseInt(tokens[1]);
                System.out.println(s.headSet(toElement).toString());
                break;
            case "last":
                System.out.println(s.last());
                break;
            default:
                break;
            }
        }
    }
}
