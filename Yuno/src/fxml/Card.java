package fxml;

import java.util.Comparator;

public class Card implements Comparator<Card> {
  private String type;
  private String color;

  private String getType() {
    return type;
  }
  private String getColor() {
    return color;
  }
  public Card(String type, String color){
    this.color = color;
    this.type = type;
  }

  @Override
  public int compare(Card o1, Card o2) {
    if (o1.getType().equals(o2.getType()) || o1.getColor().equals(o2.getColor())){
      return 0;
    }
    else {
      return  1;
    }
  }
}
