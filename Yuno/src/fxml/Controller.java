package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {
  @FXML protected ListView PlayerHandListView;
  @FXML protected GridPane GridPane_Welcome;
  @FXML protected GridPane GridPane_Setup;
  @FXML protected GridPane GridPane_Game;
  @FXML protected ImageView background_image;
  @FXML protected ToggleGroup PlayerButtons;
  private int numPlayers; // For usage when generating players and hands, because this code hasn't been written yet, we have a warning.
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
    Image bkg_img = new Image("fxml/assets/yuno-card-background.png", 0, 300, true, true, true);
    background_image.setImage(bkg_img);
  }
  @FXML protected void Continue_Button(){
    // This handles the button on the first page, and allows you to continue to the next page.
    // The way we decided to handle this was by having multiple panes, and changing their visibility when we need them.
    GridPane_Welcome.setVisible(false);
    GridPane_Setup.setVisible(true);
  }
  @FXML protected void Continue_To_Game_Button(){
    GridPane_Setup.setVisible(false);
    String Selected =  ((RadioButton)PlayerButtons.getSelectedToggle()).getText();
    if (Selected.equals("2 Players")) {
      numPlayers = 2;
    }
    else if (Selected.equals("3 Players")) {
      numPlayers = 3;
    }
    else {
      numPlayers = 4;
    }
    GridPane_Game.setVisible(true);
  }
}
