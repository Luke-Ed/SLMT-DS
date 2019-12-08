package fxml;

public class WildCard extends Card {
  String color;
  WildCard(String type) {
    super(type);
  }
  void setColor(WildCard wildCard, String color){
    this.color = color;
  }
  @Override
  public int compareTo(Card o1){
    return 0;
  }
}
