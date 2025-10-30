package eranbe.strings;

public class FrequencyAnalysis {

	public static final String alphabet = "0123456789;‡)*†:?¶.(";
	
	public static int[] analyze(String text) {	
		text = text.toLowerCase();
		int[] letterCounts = new int[alphabet.length()];
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			int idx = alphabet.indexOf(c);
			if (idx != -1) {
				letterCounts[idx]++;
			}
		}
		return letterCounts;
	}

	public static String generateDictionary(int[] frequencies) {
		char[] byFrequency = { 
				'e', 't', 'a', 'o', 'i', 'n', 
				's', 'h', 'r', 'd', 'l', 'c', 
				'u', 'm', 'w', 'f', 'g', 'y',
				'p', 'b', 'v', 'k', 'j', 'x',
				'q', 'z' };
		char[] result = new char[frequencies.length];
		for (int i = 0; i < result.length; i++) {
			int maxIdx = findMaxIdx(frequencies);
			frequencies[maxIdx] = -1;
			result[maxIdx] = byFrequency[i];
		}
		return new String(result);
	}

	public static int findMaxIdx(int[] frequencies) {
		int max = frequencies[0];
		int maxIdx = 0;
		for (int i = 1; i < frequencies.length; i++) {
			if (frequencies[i] > max) {
				max = frequencies[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	
	public static int countMatches(String alphabet, String encoding) {
		int result = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			if (alphabet.charAt(i) == encoding.charAt(i)) {
				result++;
			}
		}
		return result;
	}
	
	public static String decrypt(String text, String encoding) {
		//String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String decryptedText = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int charIndex = alphabet.indexOf(currentChar);
			if (charIndex != -1) {
				decryptedText += encoding.charAt(charIndex);
			} else {
				decryptedText += currentChar;
			}
		}
		return decryptedText;
	}

	public static void main(String[] args) {
		String text = "5 3‡‡† 305)) 6* ;48 26)4‡.)4‡);806*;48†8¶60))85;1‡(;:‡*8†83(88)5*†;46(;88*96*?;8)*‡(;485);5*†2:*‡(;4956*2(5*—4)8¶8*;4069285);)6†8)4‡‡;1(‡9;48081;8:8‡1;48†85;4)485†528806*81(‡9;48;(88;4(‡?34;48)4‡;161;:188;‡?;";
		int[] freq = analyze(text);
		//printFreqArray(freq);
		String encoding = generateDictionary(freq);
		System.out.println(encoding);
		System.out.println(alphabet);
		System.out.println(text);
		System.out.println(decrypt(text, encoding));
	}

	private static void printFreqArray(int[] freq) {
		int totalChars = 0;
		for (int i = 0; i < freq.length; i++) {
			totalChars += freq[i];
		}
		System.out.print("[");
		char c = 'a';
		for (int i = 0; i < freq.length; i++) {
			System.out.print("" + c + " " + freq[i] + " " + (int)(1000*freq[i]/(double)totalChars)/(double)10 + "%,");
			c++;
		}
		System.out.println("]");
	}
	
}
