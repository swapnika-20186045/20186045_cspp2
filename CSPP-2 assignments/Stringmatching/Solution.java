import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
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
				while(filescan.hasNextLine()) {
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
					int lcs = 0 , lcstemp = 0;
					// System.out.println(strlist[i] + "\n" + strlist[j]);
					for (String eachwordi : strlist[i].split(" ")) {
						for (String eachwordj : strlist[j].split(" ")) {
							if (eachwordi.equals(eachwordj) && eachwordi.length() > lcs) {
								lcs = eachwordi.length();
							}
						}
					}
					matchpercentmat[i][j] = (lcs * 200) / (strlist[i].length() + strlist[j].length());
				}
			}
		}
		// System.out.println(Arrays.toString(matchpercentmat));
		for (int i = 0; i < matchpercentmat.length; i++) {
			System.out.println(Arrays.toString(matchpercentmat[i]));
		}
	}
}

