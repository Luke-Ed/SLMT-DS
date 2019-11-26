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
  public void start(Stage primaryStage) {
    Card c = new Card("1", "purple");
    Card d = new Card("2", "purple");
    Card e = new Card("3", "purple");
    // Create a card that will be defined, ie having a matching file.

    ObservableList<Card> player1cards;
    player1cards = FXCollections.observableArrayList();
    player1cards.add(c);
    player1cards.add(d);
    player1cards.add(e);
    // Create an observable list, which is necessary to display an ArrayList on a ListView, from what I've seen online.

    GridPane gridPane = new GridPane();
    ImageView imageView = new ImageView();
    imageView.setImage(c.getCardImage());
    //Create an ImageView, which is necessary in order to display an image itself, and a GridPane to put everything in.

    ListView<Card> listView = new ListView<>();
    listView.setOrientation(Orientation.HORIZONTAL);
    listView.setItems(player1cards);
    // The code here creates a ListView, set's the cards to be the items in the ListView. The ListView's orientation is also changed to be horizontal.

    listView.setCellFactory(cardListView -> new CustomListCell());

    gridPane.add(new Label("Test"), 0, 0);
    //gridPane.add(imageView, 0, 1);
    gridPane.add(listView, 0, 2);
    //Some of the other elements to be displayed on our GUI

    Scene scene = new Scene(gridPane, 1000, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Luke Test");
    primaryStage.show();
    // Required code to display the Scene, and GUI for the application.
  }
}
