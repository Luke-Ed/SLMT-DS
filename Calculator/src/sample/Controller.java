package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {
  @FXML protected TextArea mainWriteArea;

  @FXML protected void handleInCPress(ActionEvent act){
    mainWriteArea.clear();
  }
  @FXML protected void handleSqRtPress(ActionEvent act){mainWriteArea.appendText("^(1/2)");}
  @FXML protected void handleIn7Press(ActionEvent act){
    mainWriteArea.appendText("7");
  }
  @FXML protected void handleIn8Press(ActionEvent act){
    mainWriteArea.appendText("8");
  }
  @FXML protected void handleIn9Press(ActionEvent act){
    mainWriteArea.appendText("9");
  }
  @FXML protected void handleInDPress(ActionEvent act){
    mainWriteArea.appendText(" / ");
  }
  @FXML protected void handleInMPress(ActionEvent act){
    mainWriteArea.appendText(" * ");
  }
  @FXML protected void handleInSqPress(ActionEvent act){
    mainWriteArea.appendText(" ^2 ");
  }
}
