package fxml;

public class WildCard extends Card {
  WildCard(String type, String color) {
    super(type, color);
  }

  @Override
  public int compareTo(Card o1){
    return 0;
  }
}
