package fxml;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CustomListCell extends ListCell<Card> {
  private VBox content;
  private Text color;
  private Text number;
  private ImageView imageView;

  public CustomListCell(){
  }
  @Override
  public void updateItem(Card c, boolean empty){
    super.updateItem(c, empty);
    if (empty || c == null){
      setText(null);
      setGraphic(null);
    }
    else{
      color = new Text(c.getColor());
      number = new Text(c.getType());
      imageView = new ImageView(c.getCardImage());
      content = new VBox(imageView, color, number);
      setGraphic(content);
    }
  }
}
