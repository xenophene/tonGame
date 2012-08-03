package deck;
import deck.Card;
import deck.Hand;
import java.util.Random;
public class Deck {
	private Card[] cards;
	private static final int size = 52;
	private static final int suits = 4;
	private int pos;
	private static final String[] faceValue = {
		"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", 
		"A"
	};
	private static final String[] suitValue = {
		"Hearts", "Clubs", "Diamonds", "Spades"
	};
	public Deck() {
		cards = new Card[size];
		for (int s = 0; s < suits; s++) {
			for (int i = 0; i < size / 4; i++) {
				cards[13*s + i] = new Card(i, s);
			}
		}
		pos = 0;
	}
	/**
	 * Shuffle the deck of cards
	 */
	public void shuffle() {
		Card[] newDeck = new Card[size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			newDeck[i] = null;
		}
		for (int i = 0; i < size; i++) {
			int j = r.nextInt(size);
			while (newDeck[j] != null) {
				j = r.nextInt(size);
			}
			Card c = cards[i];
			newDeck[j] = new Card(c.getValue(), c.getSuit());
		}
		cards = newDeck;
	}
	/**
	 * Deal card off the Deck to the Hands
	 */
	public Card dealCards() {
		if (pos == size)
			return null;
		Card c = cards[this.pos];
		this.pos++;
		return c;
	}
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(faceValue[cards[i].getValue()]
					+ " of " + suitValue[cards[i].getSuit()]);
		}
	}

}
