package fxml;

import javafx.scene.image.Image;

public class Card implements Comparable<Card> {
  private String type;
  private String color;
  private Image cardImage;

  String getType() {
    return type;
  }

  String getColor() {
    return color;
  }

  Image getCardImage(){
    return cardImage;
  }

  Card(String type, String color){
    this.color = color;
    this.type = type;
    String url = "fxml/assets/"+type+"_"+color+".png";
    cardImage = new Image(url);
  }

  @Override
  public int compareTo(Card o1) {
    if (this.getType().equals(o1.getType()) || this.getColor().equals(o1.getColor())){
      return 0;
    }
    else {
      return  1;
    }
  }

  @Override
  public String toString() {
    return "Card{" + type + " " + color + '}';
  }
}
