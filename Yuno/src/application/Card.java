package application;

public class Card {
	private String color;
	private int value;
	
	public Card(String color, int value) {
		this.color = color;
		this.value = value;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean playable(Card c2) {
		if (this.getColor()== c2.getColor() || this.getValue() == c2.getValue()){
			return true;}
		else {return false;}
	}

}
