package fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Controller {
  @FXML protected ListView<Card> playerHandListView;
  @FXML protected GridPane gridPaneWelcome;
  @FXML protected GridPane gridPaneSetup;
  @FXML protected GridPane gridPaneGame;
  @FXML protected GridPane player3NGP;
  @FXML protected GridPane player4NGP;
  @FXML protected Button player1NButton;
  @FXML protected Button player2NButton;
  @FXML protected Button player3NButton;
  @FXML protected Button player4NButton;
  @FXML protected Button continueButton;
  @FXML protected ImageView backgroundImage;
  @FXML protected ToggleGroup PlayerButtons;
  @FXML protected Label player;
  @FXML protected TextField p1Textfield;
  @FXML protected TextField p2Textfield;
  @FXML protected TextField p3Textfield;
  @FXML protected TextField p4Textfield;
  @FXML protected ImageView discardTopCardImage;
  @FXML protected Button playCardButton;
  @FXML protected Button nextPlayer;
  @FXML protected Button drawCardButton;
  Card card;

  protected Deck deck = new Deck();
  protected Deck discard = new Deck();

  PlayerCDLL.Node currentPlayerNode;

  protected PlayerCDLL players = new PlayerCDLL();
  private int numPlayers = 2;

  ObservableList<Card> player1Hand = FXCollections.observableArrayList();

  private boolean forwards = true;

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
    backgroundImage.setImage(bkg_img);
    playerHandListView.setCellFactory(PlayerHandListView -> new CustomListCell());
    deck.fill();
    card = deck.draw();
    discardTopCardImage.setImage(card.getCardImage());
  }
  @FXML protected void continueButton(){
    // This handles the button on the first page, and allows you to continue to the next page.
    // The way we decided to handle this was by having multiple panes, and changing their visibility when we need them.
    gridPaneWelcome.setVisible(false);
    gridPaneSetup.setVisible(true);
  }

  @FXML protected void handlePlayerToggle(){
    String Selected =  ((RadioButton)PlayerButtons.getSelectedToggle()).getText();
    if (Selected.equals("2 Players")){
      player3NGP.setVisible(false);
      player4NGP.setVisible(false);
      numPlayers = 2;
    }
    else if (Selected.equals("3 Players")) {
      player3NGP.setVisible(true);
      player4NGP.setVisible(false);
      numPlayers = 3;
    }
    else {
      player3NGP.setVisible(true);
      player4NGP.setVisible(true);
      numPlayers = 4;
    }
  }
  @FXML protected void createPlayer1(){
    players.addNode(new Player(p1Textfield.getText(), deck, discard));
    player1NButton.setDisable(true);
    player2NButton.setDisable(false);
  }
  @FXML protected void createPlayer2(){
    players.addNode(new Player(p2Textfield.getText(), deck, discard));
    player2NButton.setDisable(true);
    if (numPlayers ==players.getSize()){
      continueButton.setDisable(false);
    }
    else {
      player3NButton.setDisable(false);
    }
  }
  @FXML protected void createPlayer3(){
    players.addNode(new Player(p3Textfield.getText(), deck, discard));
    player3NButton.setDisable(true);
    if (numPlayers ==players.getSize()){
      continueButton.setDisable(false);
    }
    else {
      player4NButton.setDisable(false);
    }
  }
  @FXML protected void createPlayer4(){
    players.addNode(new Player(p3Textfield.getText(), deck, discard));
    player4NButton.setDisable(true);
    continueButton.setDisable(false);
  }

  @FXML protected void continueToGameButton() {
    gridPaneSetup.setVisible(false);
    gridPaneGame.setVisible(true);
    currentPlayerNode = players.getEnd();
    player1Hand.addAll(currentPlayerNode.getPlayer().getHand());
    playerHandListView.setItems(player1Hand);
  }
  @FXML protected void activatePlayCard(){
    ObservableList<Card> selectedItems = playerHandListView.getSelectionModel().getSelectedItems();
    if (selectedItems.get(0).compareTo(card)==0){
      playCardButton.setDisable(false);
    }
    else {
      playCardButton.setDisable(true);
    }
  }
  @FXML protected void playCard(){
    ObservableList<Card> selectedItems = playerHandListView.getSelectionModel().getSelectedItems();
    Player currentPlayer = currentPlayerNode.getPlayer();
    Card tempCard = selectedItems.get(0);
    whenCardPlayed(tempCard);
    currentPlayer.play(tempCard);
    card=discard.top();
    discardTopCardImage.setImage(card.getCardImage());
    playCardButton.setDisable(true);
    playerHandListView.setMouseTransparent( true );
    playerHandListView.setFocusTraversable( false );
    nextPlayer.setDisable(false);
    drawCardButton.setDisable(true);
  }

  @FXML protected void drawCard(){
    Player currentPlayer = currentPlayerNode.getPlayer();
    currentPlayer.draw();
    player1Hand.clear();
    player1Hand.addAll(currentPlayerNode.getPlayer().getHand());
  }

  @FXML protected void nextPlayer(){
    if (forwards){
      currentPlayerNode = currentPlayerNode.next;
    }
    else {
      currentPlayerNode = currentPlayerNode.previous;
    }

    player1Hand.clear();
    player1Hand.addAll(currentPlayerNode.getPlayer().getHand());
    playCardButton.setVisible(true);
    playerHandListView.setMouseTransparent( false );
    playerHandListView.setFocusTraversable( true );
    nextPlayer.setDisable(true);
  }
  private void whenCardPlayed(Card c){
    Player nextPlayer = currentPlayerNode.next.getPlayer();
    String cardType = c.getType();
    switch (cardType) {
      case "+2":
        nextPlayer.draw(2);
        break;
      case "+4":
        nextPlayer.draw(4);
        break;
      case "Skip":
        if (forwards){
          currentPlayerNode = currentPlayerNode.next;
        }
        else {
          currentPlayerNode = currentPlayerNode.previous;
        }
        break;
      case "Reverse":
        forwards = !forwards;
        break;
      case "ChangeColor":
         break; //for popup, haven't handled writing that yet so this is going to generate a warning.
      default:
        break;
    }
  }
  @FXML protected void callYuno(){
    Player Player = currentPlayerNode.getPlayer();
    ArrayList<Card> playerHand = Player.getHand();
    if (playerHand.size()!=1){
      Player.draw(2);
    }
  }
}
