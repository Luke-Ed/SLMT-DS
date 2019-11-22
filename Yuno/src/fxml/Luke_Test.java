package fxml;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Luke_Test extends Application {
  public static void main(String[] args){
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Card c = new Card("1", "purple");
    ObservableList<Card> player1cards;
    player1cards = FXCollections.observableArrayList();
    player1cards.add(c);
    // I think this should work, however I don't have a great way to test it without properly implementing an ImageView of some kind.
    GridPane gridPane = new GridPane();
    ImageView imageView = new ImageView();
    imageView.setImage(c.getCardImage());

    ListView<Card> listView = new ListView<>();
    listView.setOrientation(Orientation.HORIZONTAL);
    listView.setItems(player1cards);
    //listView.setCellFactory(cardListView -> new CustomListCell());
    gridPane.add(new Label("Test"), 0, 0);
    gridPane.add(imageView, 0, 1);
    gridPane.add(listView, 0, 2);

    Scene scene = new Scene(gridPane, 1000, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Luke Test");
    primaryStage.show();
  }
}
