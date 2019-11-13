package fxml;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {
  @FXML protected GridPane GridPane_Welcome;
  @FXML protected GridPane GridPane_Setup;
  @FXML protected GridPane GridPane_Game;
  @FXML protected ImageView background_image;
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
    Image bkg_img = new Image("fxml/assets/yuno-card-background.png",300, 0, true, true, true);
    background_image.setImage(bkg_img);
  }
  @FXML protected void Continue_Button(){
    GridPane_Welcome.setVisible(false);
    GridPane_Setup.setVisible(true);
  }
  @FXML protected void Continue_To_Game_Button(){
    GridPane_Setup.setVisible(false);
    GridPane_Game.setVisible(true);
  }
}
