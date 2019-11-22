package fxml;

import javafx.scene.image.Image;

import java.util.Comparator;

public class CardBackup implements Comparator<CardBackup> {
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
  public CardBackup(String type, String color){
    this.color = color;
    this.type = type;
    String url = "fxml/assets/"+type+"_"+color;
    cardImage = new Image(url);
  }

  @Override
  public int compare(CardBackup o1, CardBackup o2) {
    if (o1.getType().equals(o2.getType()) || o1.getColor().equals(o2.getColor())){
      return 0;
    }
    else {
      return  1;
    }
  }

}
