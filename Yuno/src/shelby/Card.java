package shelby;

public class Card {
	private String color;
	private int value;
	
	Card(String color, int value) {
		this.color = color;
		this.value = value;
	}
	
	String getColor() {
		return this.color;
	}
	
	int getValue() {
		return this.value;
	}
	
	public boolean playable(Card c2) {
		return this.getColor().equals(c2.getColor()) || this.getValue() == c2.getValue();
	}
	
	@Override
	public String toString() {
		String cardstr = "";
		cardstr += (this.getColor()+", ");
		cardstr += (this.getValue()+"\n");
		return cardstr;
	}

}
