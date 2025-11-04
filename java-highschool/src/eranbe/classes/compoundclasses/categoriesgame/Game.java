package eranbe.classes.compoundclasses.categoriesgame;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Answer[] answers;
	private String[] topics;
	private char chr;
	
	public Game(String[] topics) {
		this.topics = topics;
		answers = new Answer[topics.length];
		chr = 'a';
	}
	
	public void playGame() {
		chr = (char)new Random().nextInt('a', 'z'+1);
		System.out.println("The char is: " + chr);
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < topics.length; i++) {
			System.out.println("Category is " + topics[i]);
			System.out.print("Enter player 1 answer:");
			String p1Ans = in.nextLine();
			System.out.print("Enter player 2 answer:");
			String p2Ans = in.nextLine();
			answers[i] = new Answer(chr, topics[i], p1Ans, p2Ans);
		}
	}

	public String calcWinner() {
		int p1Score = 0, p2Score = 0;
		for (int i = 0; i < answers.length; i++) {
			Answer ans = answers[i];
			p1Score += ans.scoreWord(ans.getPlayer1Answer(), ans.getPlayer2Answer());
			p2Score += ans.scoreWord(ans.getPlayer2Answer(), ans.getPlayer1Answer()); 
		}
		if (p1Score == p2Score) {
			return "Tie: " + p1Score;
		} else if (p1Score > p2Score) {
			return "Player 1 won: " + p1Score + ":" + p2Score;
		} else {
			return "Player 2 won: " + p2Score + ":" + p1Score;  
		}
	}
	
	public static void main(String[] args) {
		String[] topics = { "Country", "City", "Animal", "Vegetable", "Mineral" };
		Game game = new Game(topics);
		game.playGame();
		System.out.println(game.calcWinner());
	}
}
