package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
  private CyclicLinkedList cll = new CyclicLinkedList();
  @FXML protected TextArea mainWriteArea;

  @FXML protected void Undo(){
    mainWriteArea.clear();
    mainWriteArea.appendText(cll.end.previous.getData());
    cll.moveEndToStart();
  }
  @FXML protected void Redo(){
    mainWriteArea.clear();
    mainWriteArea.appendText(cll.end.next.getData());
    cll.moveStartToEnd();
  }
  @FXML protected void handleCEPress(){
    String temp = mainWriteArea.getText().substring(0, mainWriteArea.getText().lastIndexOf(" "));
    mainWriteArea.clear();
    mainWriteArea.appendText(temp);
    cll.addNode(mainWriteArea.getText());
  }

  @FXML protected void handlePercentPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      String input = mainWriteArea.getText();
      ArrayList<String> stringList = new ArrayList<>(Arrays.asList(input.split(" ")));
      String temp = (Double.parseDouble(stringList.get(stringList.size()-1)))/100 +"";
      stringList.remove(stringList.size()-1);
      stringList.add(temp);
      mainWriteArea.clear();
      if (input.length()>2){
        input = input.substring(0, input.lastIndexOf(" "));
        mainWriteArea.appendText(input + " " + temp);
      }
      else {
        mainWriteArea.appendText(" "+temp);
      }
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleCPress(){
    mainWriteArea.clear();
    mainWriteArea.appendText(" ");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle7Press(){
    mainWriteArea.appendText("7");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle8Press(){
    mainWriteArea.appendText("8");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle9Press(){
    mainWriteArea.appendText("9");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle4Press(){
    mainWriteArea.appendText("4");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle5Press(){
    mainWriteArea.appendText("5");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle6Press(){
    mainWriteArea.appendText("6");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle1Press(){
    mainWriteArea.appendText("1");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle2Press(){
    mainWriteArea.appendText("2");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle3Press(){
    mainWriteArea.appendText("3");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handle0Press(){
    mainWriteArea.appendText("0");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handleDotPress(){
    mainWriteArea.appendText(".");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handleNegatePress(){
    mainWriteArea.appendText("-");
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handleSqRtPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      String input = mainWriteArea.getText();
      ArrayList<String> stringList = new ArrayList<>(Arrays.asList(input.split(" ")));
      String temp = Math.pow(Double.parseDouble(stringList.get(stringList.size()-1)), .5) +"";
      stringList.remove(stringList.size()-1);
      stringList.add(temp);
      mainWriteArea.clear();
      if (input.length()>2){
        input = input.substring(0, input.lastIndexOf(" "));
        mainWriteArea.appendText(input + " " + temp);
      }
      else {
        mainWriteArea.appendText(" " + temp);
      }
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleInvertPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      String input = mainWriteArea.getText();
      ArrayList<String> stringList = new ArrayList<>(Arrays.asList(input.split(" ")));
      String temp = Math.pow(Double.parseDouble(stringList.get(stringList.size()-1)), -1) +"";
      stringList.remove(stringList.size()-1);
      stringList.add(temp);
      mainWriteArea.clear();
      if (input.length()>2){
        input = input.substring(0, input.lastIndexOf(" "));
        mainWriteArea.appendText(input + " " + temp);
      }
      else {
        mainWriteArea.appendText(" " + temp);
      }
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleDividePress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      mainWriteArea.appendText(" / ");
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleMultiplyPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      mainWriteArea.appendText(" * ");
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleSubtractPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      mainWriteArea.appendText(" - ");
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleAddPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      mainWriteArea.appendText(" + ");
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleSqPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      String input = mainWriteArea.getText();
      ArrayList<String> stringList = new ArrayList<>(Arrays.asList(input.split(" ")));
      String temp = Math.pow(Double.parseDouble(stringList.get(stringList.size()-1)), 2) +"";
      stringList.remove(stringList.size()-1);
      stringList.add(temp);
      mainWriteArea.clear();
      if (input.length()>2){
        input = input.substring(0, input.lastIndexOf(" "));
        mainWriteArea.appendText(input + " " + temp);
      }
      else {
        mainWriteArea.appendText(" "+ temp);
      }
      cll.addNode(mainWriteArea.getText());
    }
  }
  @FXML protected void handleCuPress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      String input = mainWriteArea.getText();
      ArrayList<String> stringList = new ArrayList<>(Arrays.asList(input.split(" ")));
      String temp = Math.pow(Double.parseDouble(stringList.get(stringList.size()-1)), 3) +"";
      stringList.remove(stringList.size()-1);
      stringList.add(temp);
      mainWriteArea.clear();
      if (input.length()>2){
        input = input.substring(0, input.lastIndexOf(" "));
        mainWriteArea.appendText(input + " " + temp);
      }
      else {
        mainWriteArea.appendText(" "+temp);
      }
      cll.addNode(mainWriteArea.getText());
    }
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
      if (stringList.get(i).contains("+") && Math.round(result) == 0){
        result = (Double.parseDouble(stringList.get(i-1)) + Double.parseDouble(stringList.get(i+1)));
      }
      else if (stringList.get(i).contains("+")){
        result = result + Double.parseDouble(stringList.get(i+1));
      }
      if (stringList.get(i).contains("-") && Math.round(result) == 0 && stringList.get(i).equals("-")){
        result = (Double.parseDouble(stringList.get(i-1)) - Double.parseDouble(stringList.get(i+1)));
      }
      else if (stringList.get(i).contains("-") && stringList.get(i).equals("-")){
        result = result - Double.parseDouble(stringList.get(i+1));
      }
    }
    mainWriteArea.clear();
    mainWriteArea.appendText(" "+result);
    cll.addNode(mainWriteArea.getText());
  }
  @FXML protected void handleDeletePress(){
    String contents = mainWriteArea.getText().trim();
    if (contents.equals("")) {
      return;
    }
    else {
      String current = mainWriteArea.getText();

      if (' ' == (current.charAt(current.length()-1))){
        mainWriteArea.clear();
        mainWriteArea.appendText(current.substring(0, current.length()-4));
        cll.addNode(mainWriteArea.getText());
      }
      else {
        mainWriteArea.clear();
        mainWriteArea.appendText(current.substring(0, current.length()-2));
        cll.addNode(mainWriteArea.getText());
      }
    }
  }
}
