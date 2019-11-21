package shelby;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;
	Deck deck;
	List<Card> hand = new ArrayList<Card>();

	public Player(String name, Deck deck) {
		this.name = name;
		this.deck = deck;
		for (int i=0; i<7; i++) {this.drawCard();}
	}
	
	public String getHand() {
		String cards = "";
		for (int i=0; i<hand.size(); i++) {
			cards += (hand.get(i).toString());
		}
		return cards;
	}
	public String getName() {
		return this.name;
	}
	public void drawCard() {
		hand.add(deck.draw());
	}
}
