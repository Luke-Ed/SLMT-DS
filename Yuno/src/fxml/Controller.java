package fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {
  @FXML protected ListView<Card> PlayerHandListView;
  @FXML protected GridPane GridPane_Welcome;
  @FXML protected GridPane GridPane_Setup;
  @FXML protected GridPane GridPane_Game;
  @FXML protected GridPane Player_3_N_GP;
  @FXML protected GridPane Player_4_N_GP;
  @FXML protected Button Player_1_N_Button;
  @FXML protected Button Player_2_N_Button;
  @FXML protected Button Player_3_N_Button;
  @FXML protected Button Player_4_N_Button;
  @FXML protected Button Continue_Button;
  @FXML protected ImageView background_image;
  @FXML protected ToggleGroup PlayerButtons;
  @FXML protected Label Player;
  @FXML protected TextField p1_textfield;
  @FXML protected TextField p2_textfield;
  @FXML protected TextField p3_textfield;
  @FXML protected TextField p4_textfield;
  @FXML protected ImageView Discard_Top_Card_Image;
  @FXML protected Button Play_Card_Button;
  Card card;

  protected Deck deck = new Deck();
  protected Deck discard = new Deck();

  PlayerCDLL.Node currentPlayerNode;

  protected PlayerCDLL players = new PlayerCDLL();
  private int NumPlayers = 2;

  ObservableList<Card> player1hand = FXCollections.observableArrayList();
  //
  //  Just because I couldn't find it documented well online, I thought I would include
  //  a few options for how to add an image to an image view using an initialize in the controller
  //  to repeat; this must go in the initialize method, or so I've discovered so far, this can possibly be changed on later methods
  //  to react to a button press, etc.
  //    Image bkg_img = new Image("https://www.google.com/logos/doodles/2019/veterans-day-2019-4689153982726144-l.png", true);
  //    Image bkg_img = new Image("fxml/assets/yuno-card-background.png",300, 0, true, true, true);
  //    background_image.setImage(bkg_img);
  //
  @FXML protected void initialize(){
    Image bkg_img = new Image("fxml/assets/yuno-card-background.png");
    background_image.setImage(bkg_img);
    PlayerHandListView.setCellFactory(PlayerHandListView -> new CustomListCell());
    deck.fill();
    card = deck.draw();
    Discard_Top_Card_Image.setImage(card.getCardImage());
  }
  @FXML protected void Continue_Button(){
    // This handles the button on the first page, and allows you to continue to the next page.
    // The way we decided to handle this was by having multiple panes, and changing their visibility when we need them.
    GridPane_Welcome.setVisible(false);
    GridPane_Setup.setVisible(true);
  }

  @FXML protected void HandlePlayerToggle(){
    String Selected =  ((RadioButton)PlayerButtons.getSelectedToggle()).getText();
    if (Selected.equals("2 Players")){
      Player_3_N_GP.setVisible(false);
      Player_4_N_GP.setVisible(false);
      NumPlayers = 2;
    }
    else if (Selected.equals("3 Players")) {
      Player_3_N_GP.setVisible(true);
      Player_4_N_GP.setVisible(false);
      NumPlayers = 3;
    }
    else {
      Player_3_N_GP.setVisible(true);
      Player_4_N_GP.setVisible(true);
      NumPlayers = 4;
    }
  }
  @FXML protected void createPlayer1(){
    players.addNode(new Player(p1_textfield.getText(), deck, discard));
    Player_1_N_Button.setDisable(true);
    Player_2_N_Button.setDisable(false);
  }
  @FXML protected void createPlayer2(){
    players.addNode(new Player(p2_textfield.getText(), deck, discard));
    Player_2_N_Button.setDisable(true);
    if (NumPlayers==players.getSize()){
      Continue_Button.setDisable(false);
    }
    else {
      Player_3_N_Button.setDisable(false);
    }
  }
  @FXML protected void createPlayer3(){
    players.addNode(new Player(p3_textfield.getText(), deck, discard));
    Player_3_N_Button.setDisable(true);
    if (NumPlayers==players.getSize()){
      Continue_Button.setDisable(false);
    }
    else {
      Player_4_N_Button.setDisable(false);
    }
  }
  @FXML protected void createPlayer4(){
    players.addNode(new Player(p3_textfield.getText(), deck, discard));
    Player_4_N_Button.setDisable(true);
    Continue_Button.setDisable(false);
  }

  @FXML protected void Continue_To_Game_Button() {
    GridPane_Setup.setVisible(false);
    GridPane_Game.setVisible(true);
    currentPlayerNode = players.getEnd();
    player1hand.addAll(currentPlayerNode.getPlayer().getHand());
    PlayerHandListView.setItems(player1hand);
  }
  @FXML protected void ActivatePlayCard(){
    ObservableList<Card> selectedItems = PlayerHandListView.getSelectionModel().getSelectedItems();
    if (selectedItems.get(0).compareTo(card)==0){
      Play_Card_Button.setDisable(false);
    }
    else {
      Play_Card_Button.setDisable(true);
    }
  }
  @FXML protected void PlayCard(){
    ObservableList<Card> selectedItems = PlayerHandListView.getSelectionModel().getSelectedItems();
    Player currentPlayer = currentPlayerNode.getPlayer();
    currentPlayer.play(selectedItems.get(0));
    card=discard.top();
    Discard_Top_Card_Image.setImage(card.getCardImage());
    currentPlayerNode = currentPlayerNode.next;
    player1hand.clear();
    player1hand.addAll(currentPlayerNode.getPlayer().getHand());

  }

  @FXML protected void DrawCard(){
    Player currentPlayer = currentPlayerNode.getPlayer();
    currentPlayer.draw();
    player1hand.clear();
    player1hand.addAll(currentPlayerNode.getPlayer().getHand());
  }
}
