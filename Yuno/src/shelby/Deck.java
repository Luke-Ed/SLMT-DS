import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck = new Stack<Card>();
	
	public Deck() {
	}
	
	public void fill() {
		for(int s=0; s<2; s++) {
			for (int i=0; i<4; i++) {
				for (int j=1; j<11; j++) {
					String[] colors = {"Purple", "Blue", "Pink", "Green"};
					deck.add(new Card(colors[i], (j+"")));
				}
			}
		}
		ArrayList<Card> orderedDeck = new ArrayList<Card>(deck);
		Collections.shuffle(orderedDeck);
		deck.clear();
		deck.addAll(orderedDeck);
	}

	Card draw() {
		return deck.pop();
	}
	
	int size() {
		return deck.size();
	}
	
	void add(Card c) {
		deck.push(c);
	}
	
	Card top() {
		return deck.peek();
	}
}
