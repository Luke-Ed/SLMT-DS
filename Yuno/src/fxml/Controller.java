package fxml;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Controller {
  @FXML protected GridPane GridPane_Welcome;
  @FXML protected GridPane GridPane_Setup;
  @FXML protected GridPane GridPane_Game;

  @FXML protected void Continue_Button(){
    GridPane_Welcome.setVisible(false);
    GridPane_Setup.setVisible(true);
  }
  @FXML protected void Continue_To_Game_Button(){
    GridPane_Setup.setVisible(false);
    GridPane_Game.setVisible(true);
  }
}
