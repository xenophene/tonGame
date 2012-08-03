package deck;
import java.util.Vector;

import deck.Hand;
import deck.Deck;
import deck.Card;
public class Main {
	private Hand h1;
	private Hand h2;
	private Deck d;
	private int turn;
	Vector<Card> floor;
	/**
	 * Returns the top of the floor
	 * @return Card floor top
	 */
	public Card floorTop() {
		if (floor.isEmpty())
			return null;
		else {
			return floor.lastElement();
		}
	}
	/**
	 * Main function which starts the Game
	 * Deal Alternatively from hand h1 and h2, till either becomes
	 * empty or the next card on the floor becomes equal to
	 * the top of the floor. In this case, send all the floor cards
	 * to the appropriate hand, and empty the floor 
	 */
	public void startGame() {
		while(!h1.isEmpty() && !h2.isEmpty()) {
			System.out.println("Player1 size:" + h1.getSize() 
					+ ",Player2 size:" + h2.getSize()
					+ ",Floor size:" + floor.size());
			if (turn == 0) {
				turn = 1;
				Card c1 = h1.nextCard();
				Card c2 = floorTop();
				floor.add(c1);
				if (c2 == null)
					continue;
				if (c1.isSameValue(c2)) {
					h1.addCards(floor);
					floor.clear();
					turn = 0;
				}
			}
			else {
				turn = 0;
				Card c1 = h2.nextCard();
				Card c2 = floorTop();
				floor.add(c1);
				if (c2 == null)
					continue;
				if (c1.isSameValue(c2)) {
					h2.addCards(floor);
					floor.clear();
					turn = 1;
				}
			}
		}
	}
	public Main() {
		h1 = new Hand();
		h2 = new Hand();
		d = new Deck();
		d.shuffle();
		d.dealCards(h1, h2);
		floor = new Vector<Card>(); // the floor
		turn = 0;
		startGame();
	}
	public static void main(String[] args) {
		Main m = new Main();
	}

}