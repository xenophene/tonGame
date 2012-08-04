package deck;
import java.util.Vector;

import deck.Hand;
import deck.Deck;
import deck.Card;
public class Main {
	private Vector<Hand> hands;
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
	public boolean gameOver() {
		int cnt = 0;
		for (int i = 0; i < hands.size(); i++) {
			if (!hands.elementAt(i).isEmpty())
				cnt++;
		}
		return cnt < 2;
	}
	/**
	 * Main function which starts the Game
	 * Deal Alternatively from hand h1 and h2, till either becomes
	 * empty or the next card on the floor becomes equal to
	 * the top of the floor. In this case, send all the floor cards
	 * to the appropriate hand, and empty the floor 
	 */
	public void startGame() {
		while(!gameOver()) {
			String s = "";
			for (int i = 0; i < hands.size(); i++) {
				s += "Player" + i + " size:" + hands.elementAt(i).getSize() + ",";
			}
			s += "Floor size:" + floor.size();
			System.out.println(s);
			
			Card c1 = hands.elementAt(turn).nextCard();
			if (c1 == null) {
				turn = (turn + 1) % hands.size();
				continue;
			}
			Card c2 = floorTop();
			floor.add(c1);
			if (c2 == null) {
				turn = (turn + 1) % hands.size();
				continue;
			}
			if (c1.isSameValue(c2)) {
				hands.elementAt(turn).addCards(floor);
				floor.clear();
			}
			else {
				turn = (turn + 1) % hands.size();
			}
		}
	}
	// make an assumption that 
	public Main(int nop, int proportion) {
		hands = new Vector<Hand>();
		for (int i = 0; i < nop; i++)
			hands.add(new Hand());
		d = new Deck();
		d.shuffle();
		d.dealCards(hands);
		floor = new Vector<Card>(); // the floor
		turn = 0;
		startGame();
	}
	public static void main(String[] args) {
		Main m = new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}

}