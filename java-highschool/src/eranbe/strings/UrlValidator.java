package eranbe.strings;

public class UrlValidator {

	public static void main(String[] args) {
		System.out.println(isValidUrl("https://www.example.com"));
		System.out.println(isValidUrl("ftp://example.net"));
		System.out.println(isValidUrl("https://example."));
		System.out.println(isValidUrl("https://invalid!url.com"));
		System.out.println(isValidUrl("https://invalid*url.co.il"));
		System.out.println(isValidUrl("www.example.com"));
		System.out.println(isValidUrl("https://a.b"));
		System.out.println(isValidUrl("https://a.bbbbb"));
		System.out.println(isValidUrl("https://www.example..com"));
		System.out.println(isValidUrl("https://com"));
		System.out.println(isValidUrl("https://.com"));

	}

	private static boolean isValidUrl(String url) {
		url = url.toLowerCase();
		if (!url.startsWith("http://") && !url.startsWith("https://")) {
			System.out.print("No http(s):// prefix - ");
			return false;
		}
		if (url.contains("!") || url.contains("*")) {
			System.out.print("Contains invalid char - ");
			return false;
		}
		char lastChar = url.charAt(url.length() - 1);
		if (lastChar == '.' || lastChar == '/') {
			System.out.print("Ends with invalid char - ");
			return false;
		}
		int domainLen = 7;
		if (url.startsWith("https://")) {
			domainLen = 8;
		}
		String domain = url.substring(domainLen);
		if (domain.contains("..")) {
			System.out.print("Domain contains .. - ");
			return false;
		}
		if (!domain.contains(".")) {
			System.out.print("No . in domain - ");
			return false;
		}
		if (domain.charAt(0) == '.') {
			System.out.print("Domain starts with . - ");
			return false;
		}
		int lastDot = domain.lastIndexOf('.');
		int lenAfterDot = domain.length() - lastDot - 1;
		if (lenAfterDot > 4 || lenAfterDot < 2) {
			System.out.print("Domain suffix too long or too short - ");
			return false;
		}
		return true;
	}

}
