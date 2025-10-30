package eranbe.strings;

import java.util.Scanner;

public class PasswordValidator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name, password;
		System.out.print("Enter your name: ");
		name = in.nextLine();
		System.out.print("Enter your password: ");
		password = in.nextLine();
		if (validate(password, name)) {
			System.out.println("Password is valid");
		} else {
			System.out.println("Password is invalid");
		}
	}
	
	public static boolean validate(String password, String name) {
		password = password.toLowerCase();
		if (password.contains("password")) {
			return false;
		}
		if (password.contains(name)) {
			return false;
		}
		if (password.length() < 8) {
			return false;
		}
		return true;
	}

}
