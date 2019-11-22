import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private Deck deck;
	private Deck discard;
	private List<Card> hand = new ArrayList<Card>();

	public Player(String name, Deck deck, Deck discard) {
		this.name = name;
		this.deck = deck;
		this.discard = discard;
		for (int i=0; i<7; i++) {this.draw();}
	}
	
	String handToString() {
		StringBuilder cards = new StringBuilder();
		for (Card card : hand) {
			cards.append(card.toString()+"\n");
		}
		return cards.toString();
	}
	ArrayList<Card> getHand(){
		return (ArrayList<Card>) hand;
	}
	String getName() {
		return this.name;
	}
	void draw() {
		hand.add(deck.draw());
	}
	
	boolean play(Card c) {
		if (c.compare(discard.top()){
			
		}
	}
}
