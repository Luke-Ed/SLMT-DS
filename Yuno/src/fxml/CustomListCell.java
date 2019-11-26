package fxml;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
      String temp = c.getColor().substring(0,1).toUpperCase()+c.getColor().substring(1);
      Text color = new Text(temp);
      Text number = new Text(c.getType());
      ImageView imageView = new ImageView(c.getCardImage());
      VBox content = new VBox(imageView, color, number);
      content.setPadding(new Insets(0,5,0,5));
      content.setAlignment(Pos.CENTER);
      setGraphic(content);
    }
  }
}
