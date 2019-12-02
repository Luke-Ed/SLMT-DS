package fxml;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListViewTest extends Application {
  public static void main(String[] args){
    launch();
  }

  @Override
  public void start(Stage primaryStage) {
    Deck deck_1 = new Deck();
    deck_1.fill();
    Deck discard = new Deck();
    Player player1 = new Player("player1", deck_1, discard);
    ObservableList<Card> player1hand = FXCollections.observableArrayList();
    player1hand.addAll(player1.getHand());

    ListView<Card> hand1view = new ListView<>();
    hand1view.setOrientation(Orientation.HORIZONTAL);
    hand1view.setItems(player1hand);

    hand1view.setCellFactory(cardListView -> new CustomListCell());

    GridPane gridPane = new GridPane();
    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(100);
    gridPane.getColumnConstraints().add(col1);
    gridPane.add(hand1view,0,0);

    Scene scene = new Scene(gridPane, 1000, 800);
    scene.getStylesheets().add("fxml/dark_mode.css");
    primaryStage.setScene(scene);
    primaryStage.setTitle("ListViewTest");
    primaryStage.show();
  }
}
