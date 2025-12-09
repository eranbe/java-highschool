package eranbe.simplegames.sevencards;

public class Player {
	private String name;
	private Deck playDeck;
	private Deck winDeck;
	private int wins;
	
	public Player(String name) {
		this.name = name;
		reset();
	}
	
	public void reset() {
		this.playDeck = new Deck(false);
		this.winDeck = new Deck(false);
		wins = 0;
	}

	public void recieveCard(Card card) {
		playDeck.add(card);
	}
	
	public Card pull() {
		return playDeck.pull();
	}
	
	public void winRound(Card card1, Card card2) {
		winDeck.add(card1);
		winDeck.add(card2);
		wins++;
	}
	
	public int getWins() {
		return wins;
	}

	@Override
	public String toString() {
		return name + "\n Play: " + playDeck + "\n Win: " + winDeck; 
	}
}
