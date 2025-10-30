package eranbe.strings;


public class EmailValidator {
	public static void main(String[] args) {
		System.out.println(isValidEmail("user@example.com"));
		System.out.println(isValidEmail("user.example.com"));
		System.out.println(isValidEmail("user@examplecom"));
		System.out.println(isValidEmail("@example.com"));
		System.out.println(isValidEmail("user@example.com."));
		System.out.println(isValidEmail("user@.example.com"));
	}

	private static boolean isValidEmail(String email) {
		if (!email.contains("@")) {
			System.out.print("no @ - ");
			return false;
		}
		if (email.indexOf('@') > email.lastIndexOf('.')) {
			System.out.print("@ after last . - ");
			return false;
		}
		if (email.charAt(0) == '@') {
			System.out.print("Starts with @ - ");
			return false;
		}
		if (email.charAt(email.length() -1) == '.') {
			System.out.print("Ends with . - ");
			return false;
		}
		if (email.substring(email.indexOf('@')+1).indexOf('.') == 0) {
			System.out.print(". right after @ - ");
			return false;
		}
		return true;
	}
}
