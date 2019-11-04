package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      primaryStage.setTitle("Group 1's Calculator");
      Scene primary = new Scene(root, 360, 330);
      primary.getStylesheets().add("sample/Primary.css");
      primaryStage.setScene(primary);
      primaryStage.show();
    }


  public static void main(String[] args) {
        launch(args);
    }
}
