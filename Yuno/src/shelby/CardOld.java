public class CardOld {
	private String color;
	private int value;
	
	CardOld(String color, int value) {
		this.color = color;
		this.value = value;
	}
	
	String getColor() {
		return this.color;
	}
	
	int getValue() {
		return this.value;
	}
	
	public boolean playable(CardOld c2) {
		return this.getColor().equals(c2.getColor()) || this.getValue() == c2.getValue();
	}
	
	@Override
	public String toString() {
		String CardOldstr = "";
		CardOldstr += (this.getColor()+", ");
		CardOldstr += (this.getValue());
		return CardOldstr;
	}
  }

}
