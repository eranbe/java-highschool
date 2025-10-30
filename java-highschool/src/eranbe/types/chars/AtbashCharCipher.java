package eranbe.types.chars;

public class AtbashCharCipher {
	public static void main(String[] args) {
		// נניח ש-inputChar הוא הקלט (לדוגמה: 'C')
		char inputChar = 'C'; 

		// 1. מציאת המרחק של האות מההתחלה ('A')
		// 'C' - 'A' = 2 (C היא התו השלישי, במרחק 2 מ-A)
		int distance = inputChar - 'A'; 

		// 2. חיסור המרחק הזה מהסוף ('Z')
		// 'Z' - 2 = 'X'
		char mirrorChar = (char) ('Z' - distance);

		// פלט: X
		System.out.println("האות הסימטרית היא: " + mirrorChar); 
	}
}
