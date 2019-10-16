package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
  @FXML protected TextArea mainWriteArea;

  @FXML protected void handleCPress(){ mainWriteArea.clear(); }
  @FXML protected void handle7Press(){ mainWriteArea.appendText("7"); }
  @FXML protected void handle8Press(){ mainWriteArea.appendText("8"); }
  @FXML protected void handle9Press(){ mainWriteArea.appendText("9"); }
  @FXML protected void handle4Press(){ mainWriteArea.appendText("4"); }
  @FXML protected void handle5Press(){ mainWriteArea.appendText("5"); }
  @FXML protected void handle6Press(){ mainWriteArea.appendText("6"); }
  @FXML protected void handle1Press(){ mainWriteArea.appendText("1"); }
  @FXML protected void handle2Press(){ mainWriteArea.appendText("2"); }
  @FXML protected void handle3Press(){ mainWriteArea.appendText("3"); }
  @FXML protected void handleNegatePress(){ mainWriteArea.appendText("-"); }
  @FXML protected void handleSqRtPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals(""))
      return;
    else
      mainWriteArea.appendText("^(1/2)");
  }
  @FXML protected void handleDPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals(""))
      return;
    else
      mainWriteArea.appendText(" / ");
  }
  @FXML protected void handleMPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals(""))
      return;
    else
      mainWriteArea.appendText(" * ");
  }
  @FXML protected void handleSqPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals(""))
      return;
    else
      mainWriteArea.appendText(" ^2 ");
  }
  @FXML protected void handleEqualsPress(){
    String fulltext = mainWriteArea.getText();
    ArrayList<String> stringList = new ArrayList<>(Arrays.asList(fulltext.split(" ")));
    double result=0;
    for (int i = 0; i<stringList.size()-1; i++){
      if (stringList.get(i).contains("*") && Math.round(result) == 0){
        result = (Double.parseDouble(stringList.get(i-1)) * Double.parseDouble(stringList.get(i+1)));
      }
      else if (stringList.get(i).contains("*")){
        result = result * Double.parseDouble(stringList.get(i+1));
      }
      if (stringList.get(i).contains("/") && Math.round(result) == 0){
        result = (Double.parseDouble(stringList.get(i-1)) / Double.parseDouble(stringList.get(i+1)));
      }
      else if (stringList.get(i).contains("/")){
        result = result / Double.parseDouble(stringList.get(i+1));
      }
    }
    mainWriteArea.clear();
    mainWriteArea.appendText(""+result);
  }
}
