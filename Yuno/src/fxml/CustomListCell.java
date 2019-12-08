package fxml;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class CustomListCell extends ListCell<Card> {

  @Override
  public void updateItem(Card c, boolean empty){
    super.updateItem(c, empty);
    if (empty || c == null){
      setText(null);
      setGraphic(null);
    }
    else{
      Text color;
      if(c.getColor()!=null){
        String temp = c.getColor().substring(0,1).toUpperCase()+c.getColor().substring(1);
        color = new Text(temp);
      }
      else {
        color = new Text("");
      }
      Text number = new Text(c.getType());
      color.setFill(Color.rgb(255, 255, 255));
      number.setFill(Color.rgb(255, 255, 255));
      color.setFont(Font.font(null, FontWeight.MEDIUM, 16));
      number.setFont(Font.font(null, FontWeight.MEDIUM, 16));
      ImageView imageView = new ImageView(c.getCardImage());
      VBox content = new VBox(imageView, color, number);
      content.setPadding(new Insets(0,5,0,5));
      content.setAlignment(Pos.CENTER);
      setGraphic(content);
    }
  }
}
