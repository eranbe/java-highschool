package eranbe.simplegames.sevencards;

import java.util.Random;

public class Deck {
	public final int MAX_DECK_SIZE = 52;
	
	private Card[] cards;
	private int deckCount = -1;
	
	public Deck(boolean isFull) {
		reset(isFull);
	}
	
	public void reset(boolean isFull) {
		cards = new Card[MAX_DECK_SIZE];
		if (isFull) {
			initDeck();
		}		
	}
	
	public void shuffle() {
		for (int i = 0; i <= deckCount; i++) {
			Card tmp = cards[i];
			int swapIdx = new Random().nextInt(deckCount);
			cards[i] = cards[swapIdx];
			cards[swapIdx] = tmp;
		}
	}
	
	public Card pull() {
		Card card = cards[deckCount];
		cards[deckCount] = null;
		deckCount--;
		return card;
	}
	
	public boolean add(Card card) {
		if (deckCount == MAX_DECK_SIZE - 1)
			return false;
		deckCount++;
		cards[deckCount] = card;
		return true;
	}

	private void initDeck() {
		initSuit(Card.CLUB);
		initSuit(Card.DIAMOND);
		initSuit(Card.HEART);
		initSuit(Card.SPADE);
	}
	
	private void initSuit(char suit) {
		for (int i = 2; i <= 14; i++)
			add(new Card(suit, i));
	}

	@Override
	public String toString() {
		String result = "Deck[ ";
		for (int i = 0; i <= deckCount; i++)
			result += "" + (i+1) + ":" + cards[i].toString() + ", ";
		return result + "]";
	}
	
	public static void main(String[] args) {
		Deck d = new Deck(true);
		d.shuffle();
		System.out.println(d);
	}
}
