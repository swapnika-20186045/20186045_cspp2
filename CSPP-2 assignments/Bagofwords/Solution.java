import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Class for document.
 **/
class Document {
    /**
     * words array.
     */
    private String[] word;
    /**
     * document size
     */
    private int documentSize = 0;
    /**
     * hashmap for frequency.
     */
    private HashMap<String, Integer> freq;
    /**
     * function to read input file.
     *@param f The string
     **/
    Document(final String f) {
        word = readfile(f);
    }
    /**
     * Reads a file.
     *
     * @param      f     { parameter_description }
     *
     * @return     String[].
     */
    public String[] readfile(final String f) {
        String[] strfile = null;
        String str = "";
        try {
            // File filename1 = new File("input000.txt");
            Scanner scan = new Scanner(new File(f));
            while (scan.hasNext()) {
                //converts to lowercase.
                str += (scan.nextLine().toLowerCase().trim());
            }
            strfile = str.split(" ");
            // strfile = Arrays.remove(strfile, "");
            // for(int i=0;i<strfile.length;i++){
            //     if(strfile[i]==""){System.out.println("hi");}
            // }
            this.documentSize = strfile.length;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return strfile;
    }
    /**
     * to check frequency of a word.
     *
     * @return     HashMap<String, Integer>.
     */
    public HashMap<String, Integer> frequency() {
        freq = new HashMap<String, Integer>();
        for (int i = 0; i < word.length; i++) {
            if (freq.containsKey(word[i])) {
                freq.put(word[i], freq.get(word[i]) + 1);
            } else {
                freq.put(word[i], 1);
            }
        }
        return freq;
    }
    /**
     * Gets the document size.
     *
     * @return     The document size.
     */
    public int getDocumentSize() {
        return this.documentSize;
    }
}
/**
 * Class for distance.
 */
class Distance {
    /**
     * variable declaration.
     */
    private static final int HUNDRED = 100;
    /**
     * private declaration for a document.
     */
    private Document doc1;
    /**
     * private declaration for a document.
     */
    private Document doc2;
    /**
     * Constructs the object.
     *
     * @param      d1    The d 1
     * @param      d2    The d 2
     */
    Distance(final Document d1, final Document d2) {
        this.doc1 = d1;
        this.doc2 = d2;
        System.out.println("108 "+d1);
        System.out.println("109 "+d2);
    }
    /**
     * to find euclidean norm.
     *
     * @param      doc   The document
     *
     * @return     double.
     */
    public double euclidean(final Document doc) {
        HashMap<String, Integer> p = new HashMap<String, Integer>();
        p = doc.frequency();
        int sum = 0;
        for (String s : p.keySet()) {
            sum += Math.pow(p.get(s), 2);
        }
        double norm = Math.sqrt(sum);
        return norm;
    }
    /**
     * to find dotproduct.
     *
     * @return     double.
     */
    public double dotproduct() {
        HashMap<String, Integer> dict1 = doc1.frequency();
        HashMap<String, Integer> dict2 = doc2.frequency();
        int sum = 0;
        for (String key : dict1.keySet()) {
            if (dict2.containsKey(key)) {
                int val1 = dict1.get(key);
                int val2 = dict2.get(key);
                sum += (val1 * val2);
            }
        }
        return sum;
    }
    /**
     * to find similarity.
     *
     * @return     double.
     */
    public int similarity() {
        if (doc1.getDocumentSize() == 0 || doc2.getDocumentSize() == 0) {
            return 0;
        }
        double a = euclidean(doc1);
        double b = euclidean(doc2);
        double num = a * b;
        double den = dotproduct();
        double result = den / num;
        result *= HUNDRED;
        return (int) Math.round(result);
    }
}
/**
 * Class for solution.
 * main function.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * variable declaration.
     */
    private static final int HUNDRED = 100;
    /**
     * main function.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  { exception_description }
     */
    public static void main(final String[] args) throws Exception {
        try {
            Scanner scan = new Scanner(System.in);
            String foldername = scan.nextLine();
            final File folder = new File(foldername);
            File[] allfiles = folder.listFiles();
            String file1 = null;
            String file2 = null;
            String s = "\t";
            for (File file : allfiles) {
                s += "\t" + file.getName();
                // System.out.println("\t" + s);
            }
            System.out.println(s);
            s = "";
            // s += "\n";
            // if (allfiles.length != 0) {
            int max = 0;
            for (int i = 0; i < allfiles.length; i++) {
                s += allfiles[i].getName();
                // System.out.println("2nd"+ s);
                // s += "\n";
                for (int j = 0; j < allfiles.length; j++) {
                    Document d1 = new Document(foldername
                                               + "/" + allfiles[i].getName());
                    Document d2 = new Document(foldername
                                               + "/" + allfiles[j].getName());
                    Distance d = new Distance(d1, d2);
                    s += "\t" + d.similarity() + "" + "\t";
                    if (d.similarity() > max && d.similarity() != HUNDRED) {
                        max = d.similarity();
                        file1 = allfiles[i].getName();
                        file2 = allfiles[j].getName();
                    }
                }
                s = s.trim();
                s += "\n";
            }
            // System.out.println("\t\t");
            System.out.println(s);
            System.out.println("Maximum similarity is between "
                               + file1 + " and " + file2);
            // } else {
            // System.out.println("empty directory");
            // }
        } catch (Exception ex) {
            System.out.println("empty directory");
        }
    }
}
