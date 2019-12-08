package fxml;

public class WildCard extends Card {
  WildCard(String type) {
    super(type);
  }
  void setColor(String color){
    setCardImage(color);
  }
  @Override
  public int compareTo(Card o1){
    return 0;
  }
}
