package eranbe.classes.categoriesgame;

public class Answer {
	private String player1Answer;
	private String player2Answer;
	private char chr;
	private String topic;
	
	public Answer(char chr, String topic, String player1Answer, String player2Answer) {
		this.chr = chr;
		this.topic = topic;
		this.player1Answer = player1Answer.toUpperCase();
		this.player2Answer = player2Answer.toUpperCase();
	}
	
	public String getPlayer1Answer() {
		return player1Answer;
	}

	public String getPlayer2Answer() {
		return player2Answer;
	}
	public boolean isOnTopic(String answer) {
		return true;
	}
	public int scorePlayer1() {
		return scoreWord(player1Answer, player2Answer);
	}
	public int scorePlayer2() {
		return scoreWord(player2Answer, player1Answer);
	}
	public int scoreWord(String word, String otherWord) {
		if (isInvalidAnswer(word)) {
			return 0;
		}
		if (word.equalsIgnoreCase(otherWord)) {
			return 5;
		}
		if (!isInvalidAnswer(otherWord)) {
			return 10;
		}
		return 15;
	}
	public boolean isInvalidAnswer(String playerAnswer) {
		return playerAnswer == null || playerAnswer.length() == 0
				|| playerAnswer.charAt(0) != chr || !isOnTopic(playerAnswer);
	}
}
