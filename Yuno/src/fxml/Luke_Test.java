package fxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Luke_Test extends Application {
  public static void main(String[] args){

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Card c = new Card("1", "purple");
    // I think this should work, however I don't have a great way to test it without properly implementing an ImageView of some kind.
    GridPane gridPane = new GridPane();
    ImageView imageView = new ImageView();
    imageView.setImage(c.getCardImage());
    Scene scene = new Scene(gridPane, 600, 1000);
    primaryStage.setScene(scene);
  }
}
