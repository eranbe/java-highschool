package eranbe.strings;

public class WordFilter {
    public static void main(String[] args) {
    	String sentence = "this is an idiot badword and this is a badword as well.";
    	String[] badWords = {"idiot", "stupid", "badword"};
    	String filteredSentence = filter(sentence, badWords);
        System.out.println("Filtered sentence is: " + filteredSentence);
    }
    
    public static String filter(String sentence, String[] badWords) {
        String filteredSentence = sentence.toLowerCase();
        for (int i = 0; i < badWords.length; i++) {
        	String badWord = badWords[i];
            String replacement = generateReplacement(badWord.length());
            while (filteredSentence.toLowerCase().contains(badWord)) {
                int startIndex = filteredSentence.toLowerCase().indexOf(badWord);
                filteredSentence = filteredSentence.substring(0, startIndex)
                		+ replacement
                		+ filteredSentence.substring(startIndex+badWord.length()); 
            }
        }
        return filteredSentence;
    }

	private static String generateReplacement(int length) {
		String result = "";
		for (int i = 0; i < length; i++) {
			result += "*";
		}
		return result;
	}
}