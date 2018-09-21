import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
/**
 * Class for document.
 **/
class Document {
    String[] word;
    HashMap<String, Integer> freq;
    /**
     * function to read input file.
     **/
	Document (String f) {
		word = ReadFile(f);
	}
    /**
     * Reads a file.
     *
     * @param      f     { parameter_description }
     *
     * @return     String[].
     */
	public String[] ReadFile(String f) {
		String[] strfile = null;
		String str = "";
		try {
			// File filename1 = new File("input000.txt");
			Scanner scan = new Scanner(new File(f));
			while (scan.hasNext()) {
                //converts to lowercase.
				str += (scan.nextLine().toLowerCase());
			}
			strfile = str.split(" ");
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
}
/**
 * Class for distance.
 */
class Distance {
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
    Distance(Document d1, Document d2) {
        this.doc1 = d1;
        this.doc2 = d2;
    }
    /**
     * to find Euclidean norm.
     *
     * @param      doc   The document
     *
     * @return     double.
     */
    public double Euclidean(Document doc) {
    	HashMap<String,Integer> p = new HashMap<String,Integer>();
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
    public double DotProduct() {
    	HashMap<String, Integer> dict1 = doc1.frequency(); 	
    	HashMap<String, Integer> dict2 = doc2.frequency(); 	
        int sum = 0;
        for ( String key : dict1.keySet()) {
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
        double a = Euclidean(doc1);
        double b = Euclidean(doc2);
        double num = a * b;
        double den = DotProduct();
        double result = den / num;
        result *= 100;
        return (int)Math.round(result);
    }
}
/**
 * Class for solution.
 * main function.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
        Scanner scan = new Scanner(System.in);
        String foldername = scan.nextLine();
        final File folder = new File(foldername);
        File[] allfiles = folder.listFiles();
        String file1 = null;
        String file2 = null;
        String s = "\t\t";
        for (File file: allfiles) {
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
                    Document d1 = new Document(foldername + "/" + allfiles[i].getName());
                    Document d2 = new Document(foldername + "/" + allfiles[j].getName());
                    Distance d = new Distance(d1, d2);
                    s += "\t" + d.similarity() + "" + "\t";
                    if (d.similarity() > max && d.similarity() != 100) {
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
            System.out.println("Maximum similarity is between " + file1 + " and " + file2);
        // } else {
            // System.out.println("empty directory");
        // }
    } catch (Exception ex) {
        System.out.println("empty directory");
    }
}
}
