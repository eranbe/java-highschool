package eranbe.strings;

public class CaesarCipherUsingMod {

	private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private final int shift = 3;

	public String encrypt(String text) {
		String encryptedText = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int charIndex = alphabet.indexOf(currentChar);
			if (charIndex != -1) {
				encryptedText += alphabet.charAt((charIndex + shift) % alphabet.length());
			} else {
				encryptedText += currentChar;
			}
		}
		return encryptedText;
	}

	public String decrypt(String text) {
		String decryptedText = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int charIndex = alphabet.indexOf(currentChar);
			if (charIndex != -1) {
				decryptedText += alphabet.charAt((charIndex - shift) % alphabet.length());
			} else {
				decryptedText += currentChar;
			}
		}
		return decryptedText;
	}

	public static void main(String[] args) {
		CaesarCipherUsingMod cipher = new CaesarCipherUsingMod();

		String originalText = "hello world";

		String encrypted = cipher.encrypt(originalText);
		System.out.println("Original Text: " + originalText);
		System.out.println("Encrypted Text: " + encrypted);
		// Output: khoor zruog
		System.out.println("Decrypted Text: " + cipher.decrypt(encrypted));
	}

}
