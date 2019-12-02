package fxml;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("YunoX.fxml"));
      primaryStage.setTitle("Yuno");
      Scene primary = new Scene(root, 1000, 600);
      primary.getStylesheets().add("fxml/dark_mode.css");
      primaryStage.setScene(primary);
      primaryStage.show();
    }
    //Card Size in inches: 2.45x3.5; I'm probably going do double this for some of my design work 4.9*7

  public static void main(String[] args) {
        launch(args);
    }
}
