package eranbe.bagrut.q899371.a2026.q3;

public class BullsAndCows {
	public static void guess(String secretStr, String playerStr) {
		if (secretStr.length() != playerStr.length()) {
			System.out.println("Size Error");
			return;
		}
		int bulCount = 0;
		int hitCount = 0;
		int missCount = 0;
		for (int i = 0; i < secretStr.length(); i++) {
			char secretChar = secretStr.charAt(i);
			if (secretChar == playerStr.charAt(i)) {
				bulCount++;
			} else {
				// אם אנחנו כאן, מובטח שאין בול
				boolean found = false;
				for (int j = 0; j < playerStr.length(); j++) {
					if (secretChar == playerStr.charAt(j)) {
						hitCount++;
						found = true;
					}
				}
				if (!found) {
					missCount++;
				}
			}
		}
		System.out.println("Bul: " + bulCount);
		System.out.println("Hit: " + hitCount);
		System.out.println("Miss: " + missCount);
	}
	
	public static void guess2(String secretStr, String playerStr) {
		if (secretStr.length() != playerStr.length()) {
			System.out.println("Size Error");
			return;
		}
		int bulCount = 0;
		int hitCount = 0;
		for (int i = 0; i < secretStr.length(); i++) {
			char secretChar = secretStr.charAt(i);
			char playerChar = playerStr.charAt(i);
			if (secretChar == playerChar) {
				bulCount++;
			} else if (secretStr.indexOf(playerChar) != -1) {
				// אם אנחנו כאן, מובטח שאין בול
				hitCount++;
			}
		}
		System.out.println("Bul: " + bulCount);
		System.out.println("Hit: " + hitCount);
		System.out.println("Miss: " + (playerStr.length() - (bulCount + hitCount)));
	}
	
	public static void main(String[] args) {
		guess("FGAV", "AGCF");
		guess2("FGAV", "AGCF");
	}
}
