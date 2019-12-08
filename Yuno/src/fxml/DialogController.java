package fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;


public class DialogController {
  private WildCard wildCard;
  protected void setWildCard(WildCard wildCard){
    this.wildCard = wildCard;
  }
  @FXML protected void blueButton(ActionEvent actionEvent){
    wildCard.setColor("blue");
    closeStage(actionEvent);
  }
  @FXML protected void greenButton(ActionEvent actionEvent){
    wildCard.setColor("green");
    closeStage(actionEvent);
  }
  @FXML protected void pinkButton(ActionEvent actionEvent){
    wildCard.setColor("pink");
    closeStage(actionEvent);
  }
  @FXML protected void purpleButton(ActionEvent actionEvent){
    wildCard.setColor("purple");
    closeStage(actionEvent);
  }
  private void closeStage(ActionEvent actionEvent){
    Node source = (Node) actionEvent.getSource();
    Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
  }
}
