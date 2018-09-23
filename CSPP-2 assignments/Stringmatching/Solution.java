import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {

	public static int lcs(String doc1, String doc2) {
		int lcsmax = 0, lcs = 0, temp = 0;
		for (int indexi = 0; indexi < doc1.length() - 1; indexi++) {
			int indexj = 0;
			while (indexj < doc2.length() - 1) {
				temp = indexi;
				lcs = 0;
				if (doc1.charAt(temp) == (doc2.charAt(indexj))) {
					while (doc1.charAt(temp) == (doc2.charAt(indexj)) && indexj < doc2.length() - 1 && temp < doc1.length() - 1) {
						lcs++;
						indexj++;
						temp++;
					}
					if (lcs > lcsmax) {
						lcsmax = lcs;
					}
				} else {
					indexj++;
				}
			}
		}
		return lcsmax + 1;
	}

	public static void printResult(float[][] matchpercentmat, File[] filelist) {
		String[] fileListAsString = new String[filelist.length];
		for (int i = 0; i < filelist.length; i++) {
			// fileListAsString[i] = filelist[i].toString().split("\\")[1];
			for (int j = 0; i < filelist[i].toString().length(); j++) {
				if (filelist[i].toString().charAt(j) == '\\') {
					fileListAsString[i] = filelist[i].toString().substring(j + 1);
					break;
				}
			}
		}
		String res = "         ";
		for (String eachFile : fileListAsString) {
			// res += eachFile + "\t";
			int numberOfSpaces = 13 - eachFile.length();
			for (int spindex = 0; spindex < numberOfSpaces; spindex++) {
				res += " ";
			}
			res += eachFile;
		} res += "\n";
		for (int i = 0; i < fileListAsString.length; i++) {
			res += fileListAsString[i];
			for (int j = 0; j < fileListAsString.length; j++) {
				// res += "\t" + matchpercentmat[i][j] + "\t";
				int numberOfSpaces = 13 - (matchpercentmat[i][j] + "").length();
				for (int spindex = 0; spindex < numberOfSpaces; spindex++) {
					res += " ";
				}
				res += matchpercentmat[i][j] + "";

			} res += "\n";
		}
		System.out.print(res);
		float maxpercetmatch = 0;
		String file1 = "", file2 = "";
		for (int i = 0; i < filelist.length; i++) {
			for (int j = 0; j < filelist.length; j++) {
				if (i < j && maxpercetmatch < matchpercentmat[i][j]) {
					file1 = fileListAsString[i];
					file2 = fileListAsString[j];
					maxpercetmatch = matchpercentmat[i][j];
				}
			}
		}
		System.out.println("Maximum similarity is between "
		                   + file1 + " and " + file2);
	}

	public static void main(String[] args) throws Exception {
		try {
			Scanner scan = new Scanner(System.in);
			String foldername = scan.next();
			File folder = new File(foldername);
			File[] filelist = folder.listFiles();
			String[] strlist = new String[filelist.length];
			// System.out.println(Arrays.toString(filelist));
			try {
				int filecount = 0;
				for (File file : filelist) {
					Scanner filescan = new Scanner(file);
					String str = "";
					while (filescan.hasNextLine()) {
						str += filescan.nextLine() + " ";
					}
					// System.out.println(str);
					strlist[filecount++] = str.trim();
				}
				// System.out.println(Arrays.toString(strlist));
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
			}

			float[][] matchpercentmat = new float[filelist.length][filelist.length];
			for (int i = 0; i < filelist.length; i++) {
				for (int j = 0; j < filelist.length; j++) {
					if (i == j) {
						matchpercentmat[i][j] = 100;
					} else {
						// int lcs = 0 , lcstemp = 0;
						// // System.out.println(strlist[i] + "\n" + strlist[j]);
						// for (String eachwordi : strlist[i].replace(".", " ").split(" ")) {
						// 	for (String eachwordj : strlist[j].replace(".", " ").split(" ")) {
						// 		if (eachwordi.equals(eachwordj) && eachwordi.length() > lcs) {
						// 			lcs = eachwordi.length();
						// 		}
						// 	}
						// }
						// matchpercentmat[i][j] = (lcs * 200) / (strlist[i].length() + strlist[j].length());

						int lcsmax = 0;
						if (!(strlist[i].equals("") || strlist[j].equals(""))) {
							if (strlist[i].length() > strlist[j].length()) {
								lcsmax = lcs(strlist[i], strlist[j]);
							} else {
								lcsmax = lcs(strlist[j], strlist[i]);
							}
						}
						matchpercentmat[i][j] = (lcsmax * 200) / (strlist[i].length() + strlist[j].length());
					}
				}
			}
			// System.out.println(Arrays.toString(matchpercentmat));
			// for (int i = 0; i < matchpercentmat.length; i++) {
			// 	System.out.println(Arrays.toString(matchpercentmat[i]));
			// }
			printResult(matchpercentmat, filelist);
		} catch (Exception e) {
			System.out.println("Empty Directory");
		}
	}
}

