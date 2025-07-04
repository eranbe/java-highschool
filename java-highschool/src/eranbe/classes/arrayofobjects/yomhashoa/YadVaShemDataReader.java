package eranbe.classes.arrayofobjects.yomhashoa;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * מחלקת שירות כדי לקרווא את נתוני חסידי אומות העולם מקובץ שנמצא ב-Google Drive או מקובץ לוקאלי
 * היא משתמשת במחלקה Hasid כדי להשתמש במחלקה זו, הוסיפו את השורה הבאה ל-main 
 * שלכם כדי לקרוא מקוןבץ לוקאלי: 
 * Hasid[] hasidim = YadVaShemDataReader.readHasidData(YadVaShemDataReader.Source.FILE);
 * או זו כדי לקרוא מהקובץ המרוחק:
 * Hasid[] hasidim = YadVaShemDataReader.readHasidData(YadVaShemDataReader.Source.URL); 
 */
public class YadVaShemDataReader {
	public enum Source {
		URL, FILE
	}

	private static boolean debugMode = false;

	private static final String URL = "https://drive.google.com/uc?export=download&id=1MWVC6Mz5sODkw610uNQaa7AOLl7MyhRE";

	private static final String FILENAME = "RighteousAmongTheNations.csv";

	public static Hasid[] readHasidData(Source source) {
		String[] lines;

		switch (source) {
		case URL:
			lines = readDataFromUrl();
			break;
		case FILE:
			lines = readDataFromLocalFile();
			break;
		default:
			lines = new String[0];
		}
		if (lines.length <= 1)
			return new Hasid[0]; // אין נתונים או רק כותרת

		List<Hasid> hList = new LinkedList<Hasid>();

		int errorCount = 0;
		for (int i = 1; i < lines.length; i++) { // מתחילים מ-1 כדי לדלג על כותרת
			String line = lines[i].trim();
			try {

				int comma1 = line.indexOf(','); // מיקום הפסיק הראשון
				int comma2 = line.indexOf(',', comma1 + 1); // מיקום הפסיק השני
				int comma3 = line.indexOf(',', comma2 + 1); // מיקום הפסיק
															// השלישי

				String name = line.substring(0, comma1); // שדה 0
				String yearStr = line.substring(comma1 + 1, comma2); // שדה 1
				String country = line.substring(comma2 + 1, comma3); // שדה 2
				String qtyStr = line.substring(comma3 + 1); // שדה 3

				int year = Integer.parseInt(yearStr);
				int qty = Integer.parseInt(qtyStr);

				hList.add(new Hasid(name, year, country, qty));
			} catch (Exception e) {
				errorCount++;
			}
		}

		if (debugMode) {
			System.err.println("# Error records: " + errorCount);
		}
		return hList.toArray(new Hasid[0]);
	}

	private static String[] readDataFromLocalFile() {
		String[] lines;
		try {
			File myObj = new File(FILENAME);
			Scanner sc = new Scanner(myObj);
			StringBuffer sb = new StringBuffer();
			while (sc.hasNext()) {
				sb.append(sc.nextLine());
				sb.append("\n");
			}
			sc.close();
			lines = sb.toString().split("\n");
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			lines = new String[0];
		}
		return lines;
	}

	private static String[] readDataFromUrl() {
		String[] lines;
		try {
			URL url = new URL(URL);
			Scanner sc = new Scanner(url.openStream());
			StringBuffer sb = new StringBuffer();
			while (sc.hasNext()) {
				sb.append(sc.nextLine());
				sb.append("\n");
			}
			sc.close();
			lines = sb.toString().split("\n");
		} catch (Exception ex) {
			System.err.println("Error reading CSV file:");
			System.err.println(ex.getMessage());
			lines = new String[0];
		}
		return lines;
	}

	public static void main(String[] args) {
		Hasid[] hasidim = readHasidData(Source.FILE);
		for (int i = 0; i < hasidim.length; i++) {
			Hasid h = hasidim[i];
			System.out.println((i + 1) + ": " + h);
		}
	}
}
