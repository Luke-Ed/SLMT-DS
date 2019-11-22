package fxml;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CustomListCell extends ListCell<Card> {
  private VBox content;
  private Text color;
  private Text number;
  private Card card;
  private ImageView imageView;

  public CustomListCell(){
    super();
    color = new Text(card.getColor());
    number = new Text(card.getType());
    imageView = new ImageView(card.getCardImage());
    content = new VBox(imageView, color, number);
  }
}
