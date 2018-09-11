import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Swapnika Vakacharla
 */
/**.
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**.
     * Constructs the object.
     * @param      s     { parameter_description }
     */
    SetEmptyException(final String s) {
        super(s);
    }
}
/**.
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**.
     * Constructs the object.
     * @param      s     { parameter_description }
     */
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
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
    public int[] subSet(final int fromElement, final int toElement) throws
                                        InvalidSubsetSelectionException {
        if (fromElement > toElement) {
            throw new InvalidSubsetSelectionException(
                    "Invalid Arguments to Subset Exception");
        } else {
            int fromindex = getIndex(fromElement);
            int toindex = getIndex(toElement);
            int[] subset = new int[toindex - fromindex];
            int k = 0;
            for (int i = fromindex; i < toindex; i++) {
                subset[k++] = this.get(i);
            }
            return subset;
        }
    }
    /**
     * print elements that are strictly less than toElement.
     * @param toElement   The last element
     * @return Set
     * @throws     SetEmptyException                { exception_description }
     * @throws     InvalidSubsetSelectionException  { exception_description }
     */
    public int[] headSet(final int toElement) throws SetEmptyException,
                        InvalidSubsetSelectionException {
        if (toElement <= get(0)) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return subSet(get(0), toElement);
        }
    }
    /**
     * print the last element of the set.
     *
     * @return     { description_of_the_return_value }
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException {
        if (size <= 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return get(size() - 1);
    }
    /**.
     * Gets the index.
     *
     * @param      item  The item
     *
     * @return     The index.
     */
    public int getIndex(final int item) {
        for (int i = 0; i < size(); i++) {
            if (item <= this.get(i)) {
                return i;
            }
        }
        return size();
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
                value.add(newArray[i]);
        }
        return intersection(value);
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
            case "contains":
                System.out.println(s.
                    contains(Integer.parseInt(tokens[1])));
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
                try {
                    String[] arrstring = tokens[1].split(",");
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                            Integer.parseInt(arrstring[1]));
                    Set subset = new Set();
                    subset.addAll(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                } catch (InvalidSubsetSelectionException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "headSet":
                try {
                    int[] headarray = s.headSet(Integer.parseInt(tokens[1]));
                    Set headset = new Set();
                    headset.addAll(headarray);
                    if (headset != null) {
                        System.out.println(headset);
                    }
                } catch (SetEmptyException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidSubsetSelectionException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {
                    System.out.println(s.last());
                } catch (SetEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            default:
                break;
            }
        }
    }
}
