import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

class Document {
	String[] word;
	HashMap<String, Integer> val;

	Document (String f) {
		word = Formatread(f);
		// System.out.println(Arrays.toString());

	}
	public String[] Formatread(String f) {
		String[] f1 = null;
		String se = "";
		try {
			// File filename1 = new File("input000.txt");
			Scanner s1 = new Scanner(new File(f));
			while (s1.hasNext()) {
				se += (s1.nextLine().replaceAll("[^a-zA-Z0-9_]+"," ").toLowerCase())+" ";
			}
			f1 = se.split(" ");
		} catch (FileNotFoundException e) {
				e.printStackTrace();
				// return null;
			}
		return f1;

	}
	public HashMap<String, Integer> frequency() {
		val = new HashMap<String, Integer>();
		for (int i = 0; i < word.length; i++) {
			if (val.containsKey(word[i])) {
				val.put(word[i], val.get(word[i]) + 1);
			} else {
				val.put(word[i], 1);
			}
		}
		return val;
	}
	// public String[] freqarrays() {
	// 	Set name = val.keySet();
	// 	System.out.println(name);
	// 	return null;
	// }
}
class Distance {
    private Document doc1;
    private Document doc2;
    Distance(Document d1, Document d2) {
        doc1 = d1;
        doc2 = d2;

    }
    public double Euclidean(Document d) {
    	HashMap<String,Integer> p = new HashMap<String,Integer>();
    	p = d.frequency();
        long sum = 0;
        for(Map.Entry<String, Integer> m: p.entrySet()) {
            // int val = (int)m.getValue();
            sum += m.getValue()*m.getValue();
        }
        double prod = Math.sqrt(sum);
        return prod;
    }
    public double DotProduct() {
    	HashMap<String, Integer> dict1 = doc1.frequency(); 	
    	HashMap<String, Integer> dict2 = doc2.frequency(); 	
        String key;
        int sum = 0;
        for (Map.Entry<String, Integer> m: dict1.entrySet()) {
            key = m.getKey();
            if (dict2.containsKey(key)) {
                int val1 = dict1.get(key);
                int val2 = dict2.get(key);
                sum += (val1*val2);
            }
        }
        return sum;
    }
    public double similarity() {
        double a = Euclidean(doc1);
        double b = Euclidean(doc2);
        double num = a*b;
        double deno = DotProduct();
        double result = deno/num;
        result = result * 100;
        return Math.round(result);
    }
}
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String foldername = scan.nextLine();
        // Inpfromfolder i = new Inpfromfolder();
        final File folder = new File(foldername);
        // ArrayList<String> filenames= i.listFilesForFolder(folder);
        File[] allfiles = folder.listFiles();
        // System.out.println(Arrays.toString(allfiles));
        String s = "\t";
        for (File fil: allfiles) {
            s += fil.getName() + "\t";
        }
        // s = s.trim();
        // s = s.substring(0, s.length()-4);
        s += "\n";
        if (allfiles.length != 0) {
            // System.out.println("Entered if");
            for (File file1: allfiles) {
                s += file1.getName() + "\t";
                for (File file2: allfiles) {
                    Document d1 = new Document(file1 + "");
                    Document d2 = new Document(file2 + "");
                    Distance d = new Distance(d1, d2);
                    s += d.similarity() + "" + "\t";
                }
                s = s.trim();
                s += "\n";
            }
            System.out.println(s);
        } else {
            System.out.println("empty directory");
        }
        // f.loadWordstodict(filename1);
        // f.loadWordstodict(filename2);
    }
}
