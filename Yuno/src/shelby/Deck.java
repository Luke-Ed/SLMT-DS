package shelby;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
	String[] colors = {"Purple","Yellow","Blue","Green"};
	ArrayList<Card> orderedDeck = new ArrayList<Card>();
	Stack<Card> deck = new Stack<Card>();
	
	public Deck() {
		for(int s=0; s<2; s++) {
			for (int i=0; i<4; i++) {
				for (int j=1; j<11; j++) {
					deck.add(new Card(colors[i], j));
				}
			}
		}
		for (int i=0; i<deck.size(); i++) {
			orderedDeck.add(deck.get(i));
		}
		Collections.shuffle(orderedDeck);
		deck.clear();
		for (int i=0; i<orderedDeck.size(); i++) {
			deck.add(orderedDeck.get(i));
		}
	}
	
	public Card draw() {
		return deck.pop();
	}
	
	public int size() {
		return deck.size();
	}
}
