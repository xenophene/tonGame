package deck;
import java.util.Vector;
/**
 * Hand is the hand given to a player. It is dealt during a dealing
 * It is also updated whenever a set of Cards is added
 * The set of cards is maintained as a Queue
 * @author xenoph
 *
 */
public class Hand {
	private Vector<Card> cards;
	private int size;
	public Hand() {
		cards = new Vector<Card>();
		size = 0;
	}
	public void addCard(Card c) {
		cards.add(c);
		size++;
	}
	public int getSize() {
		return this.size;
	}
	public void addCards(Vector<Card> nc) {
		cards.addAll(nc);
	}
	/**
	 * the next card in the hand
	 * @return the card c
	 */
	public Card nextCard() {
		if (!cards.isEmpty()) {
			Card c = cards.firstElement();
			cards.remove(0);
			return c;
		}
		return null;
	}

}