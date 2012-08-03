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
	public Hand() {
		cards = new Vector<Card>();
	}
	public void addCard(Card c) {
		cards.add(c);
	}
	public int getSize() {
		return cards.size();
	}
	public boolean isEmpty() {
		return cards.isEmpty();
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