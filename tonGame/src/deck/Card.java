package deck;
/**
 * Card class manipulates a single card, part of a larger deck
 * or a larger hand
 * @author xenoph
 *
 */
public class Card {
	private int value;	// card value from 1-14
	private int suit;	// card suit number 0-3
	public Card(int v, int s) {
		this.value = v;
		this.suit = s;
	}
	public int getValue() {
		return this.value;
	}
	public int getSuit() {
		return this.suit;
	}
	/**
	 * Compare the value of this card with the card c
	 * @param c: the Card to be compared
	 * @return if the values are same
	 */
	public boolean isSameValue(Card c) {
		return this.value == c.getValue();
	}
	/**
	 * Check equality of two cards c1 and c2
	 * @param c1
	 * @param c2
	 * @return
	 */
	public boolean areSameValue(Card c1, Card c2) {
		return c1.getValue() == c2.getValue();
	}
}
