package shelby;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private Deck deck;
	private List<Card> hand = new ArrayList<Card>();

	public Player(String name, Deck deck) {
		this.name = name;
		this.deck = deck;
		for (int i=0; i<7; i++) {this.drawCard();}
	}
	
	String getHand() {
		StringBuilder cards = new StringBuilder();
		for (Card card : hand) {
			cards.append(card.toString());
		}
		return cards.toString();
	}
	String getName() {
		return this.name;
	}
	private void drawCard() {
		hand.add(deck.draw());
	}
}
