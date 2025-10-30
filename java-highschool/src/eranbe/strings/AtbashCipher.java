package eranbe.strings;

public class AtbashCipher {
	public String encrypt(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String result = "";
		text = text.toLowerCase();
		
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			int idx = alphabet.indexOf(c); 
			if (idx != -1) {
				result += alphabet.charAt(alphabet.length() - idx - 1);
			} else {
				result += c;
			}
		}
		return result;
	}
	
	public String decrypt(String text) {
		return encrypt(text);
	}
	
	public static void main(String[] args) {
		AtbashCipher cipher = new AtbashCipher();
		String originalText = "apple and honey";

		String encrypted = cipher.encrypt(originalText);
		System.out.println("Original Text: " + originalText);
		System.out.println("Encrypted Text: " + encrypted);
		// Output: zkkov zmw slmvb
		System.out.println("Decrypted Text: " + cipher.decrypt(encrypted));

	}

}
