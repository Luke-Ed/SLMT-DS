package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {	
	
	//Game Variables
	private int players;
	
//	fxml.Player p1 = new fxml.Player();
//	fxml.Player p2 = new fxml.Player();
//	fxml.Player p3 = new fxml.Player();
//	fxml.Player p4 = new fxml.Player();
	
	//GUI Variables
	private Button btnOpening = new Button("Let's get started!");
	private Button btnStartGame = new Button("Start your game!");
	
	private HBox hbCreateGame = new HBox();
	private HBox hbGame = new HBox();
	
	private Label lblOpening = new Label("Welcome to Yuno!");
	
	private RadioButton rb1p = new RadioButton("1 player");
	private RadioButton rb2p = new RadioButton("2 players");
	private RadioButton rb3p = new RadioButton("3 players");
	private RadioButton rb4p = new RadioButton("4 players");
	
	ToggleGroup tgNumPlayers = new ToggleGroup();


	///////////////
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//build
			GridPane grdPane = buildGui();
			//display
			Scene scene = new Scene(grdPane, 1000, 600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Yuno");
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private GridPane buildGui() {
		GridPane grdPane = new GridPane();
		grdPane.getChildren().addAll(buildOpeningPane(), buildCreateGamePane(), buildGamePane());
		return grdPane;
	}
	
	private Pane buildOpeningPane() {
		HBox root = new HBox();
		VBox vbOpening = new VBox();
		btnOpening.setOnAction(new EHbtnOpening());
		vbOpening.getChildren().addAll(lblOpening, btnOpening);
		vbOpening.setPrefSize(900, 400);
		root.getChildren().add(vbOpening);
		return root;
	}
	
	private Pane buildCreateGamePane() {
		hbCreateGame.setVisible(false);
		VBox vbSetPlayers = new VBox();
		vbSetPlayers.getChildren().add(new Label("How many players?"));
		
		btnStartGame.setOnAction(new EHbtnStartGame());
		
		vbSetPlayers.getChildren().addAll(rb1p, rb2p, rb3p, rb4p);
		rb1p.setOnAction(new EHrb1p());
		rb1p.setSelected(true);
		rb2p.setOnAction(new EHrb2p());
		rb3p.setOnAction(new EHrb3p());
		rb4p.setOnAction(new EHrb4p());
		
		hbCreateGame.getChildren().addAll(vbSetPlayers, btnStartGame);		
		return hbCreateGame;
	}
	
	private Pane buildGamePane() {
		hbGame.setVisible(false);
		Label lbltest = new Label("actual gameplay will go here");
		
		hbGame.getChildren().add(lbltest);
		
		return hbGame;
	}
	
	//////////
	
	private class EHbtnOpening implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){
			lblOpening.setVisible(false);
			btnOpening.setVisible(false);
			hbCreateGame.setVisible(true);
		}
	}
	
	private class EHbtnStartGame implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){
			hbCreateGame.setVisible(false);
			hbGame.setVisible(true);
		}
	}
	
	private class EHrb1p implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			rb1p.setSelected(true);
			rb2p.setSelected(false);
			rb3p.setSelected(false);
			rb4p.setSelected(false);
			players = 1;
		}
	}
	
	private class EHrb2p implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			rb1p.setSelected(false);
			rb2p.setSelected(true);
			rb3p.setSelected(false);
			rb4p.setSelected(false);
			players = 2;
		}
	}
	
	private class EHrb3p implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			rb1p.setSelected(false);
			rb2p.setSelected(false);
			rb3p.setSelected(true);
			rb4p.setSelected(false);
			players = 3;
		}
	}
	
	private class EHrb4p implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			rb1p.setSelected(false);
			rb2p.setSelected(false);
			rb3p.setSelected(false);
			rb4p.setSelected(true);
			players = 4;
		}
	}
	
	//////
	
	public static void main(String[] args) {
		launch();
	}
}
