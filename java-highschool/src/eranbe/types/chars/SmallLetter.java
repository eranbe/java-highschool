package eranbe.types.chars;

import java.util.Scanner;

public class SmallLetter {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		char letter, newLetter;
		int newCode;
		System.out.println("enter a capital letter");
		letter = in.next().charAt(0) ;
		newCode = (int) letter + ('a' - 'A');
		newLetter = (char) newCode;
		System.out.println("the capital letter is: " + letter);
		System.out.println("the small letter is: " + newLetter );
	}

}
