package eranbe.simplegames.sevencards;

/**
 * https://docs.google.com/document/d/1UhWll-1TXreNi-cLLx_zuUvUDhkq-Ats/edit?usp=sharing&ouid=101494708632928300874&rtpof=true&sd=true
 */
public class Game {
	private static final int MAX_ROUNDS = 7;
	private Deck deck;
	private Player player1;
	private Player player2;
	private int currentRound;
	
	public Game(String player1Name, String player2Name) {
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
	}
	
	public void startGame() {
		resetGame();
		dealInitialCards();
	}
	
	public void dealInitialCards() {
		for (int i = 0; i < MAX_ROUNDS; i++) {
			player1.recieveCard(deck.pull());
			player2.recieveCard(deck.pull());
		}
	}
	
	public void playRound() {
		Card p1Card = player1.pull();
		Card p2Card = player2.pull();
		if (p1Card.getValue() > p2Card.getValue()) {
			player1.winRound(p1Card, p2Card);
		} else if (p1Card.getValue() < p2Card.getValue()) {
			player2.winRound(p1Card, p2Card);
		} else {
			deck.add(p1Card);
			deck.add(p2Card);
		}
		currentRound++;
	}
	
	public void playRounds() {
		for (int i = 0; i < MAX_ROUNDS; i++)
			playRound();
	}
	
	public void run() {
		playRounds();
		int p1Wins = player1.getWins();
		int p2Wins = player2.getWins();
		if (p1Wins > p2Wins) {
			System.out.println("Player 1 won! " + p1Wins + ":" + p2Wins);
		} else if (p2Wins > p1Wins) {
			System.out.println("PLayer 2 won! " + p2Wins + ":" + p1Wins);
		} else {
			System.out.println("It's a draw.");
		}
		System.out.println(player1);
		System.out.println(player2);
	}
	
	public void resetGame() {
		this.currentRound = 0;
		player1.reset();
		player2.reset();
		deck = new Deck(true);
		deck.shuffle();
	}
	
	public static void main(String[] args) {
		Game g = new Game("Alice", "Bob");
		g.startGame();
		g.run();
	}
}
