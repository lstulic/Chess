import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.*;

public class UserInterface extends Application{
	
	public String W_Pawn = "file:images/white_pawn.png";
	public String B_Pawn = "file:images/black_pawn.png";
	
	//declaring board and fields
	static GridPane board;
	static Button[][] fields;
	
	
	public void start(Stage stage) {
		
		stage.setScene(createMenu(stage));
		stage.setTitle("Chess");
		stage.show();
	}
	
	public static void launch() {
		launch(UserInterface.class);
	}
	
	//creates main menu
	private Scene createMenu(Stage stage) {
		//declaring items
		VBox menu = new VBox();
				
		Button play = new Button("Play");
		Button options = new Button("Options");
		Button exit = new Button("Exit");
		
		
		//adding image file and creating a background
		BackgroundImage backgroundImage = new BackgroundImage
				(new Image("file:images/chess.jpg"),
				BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT,
				new BackgroundSize(1.0, 1.0, true, true, false, false));
		Background background = new Background(backgroundImage);
		
		
		//menu looks
		menu.setSpacing(10);
		menu.setAlignment(Pos.CENTER);
		menu.setPrefSize(800, 800);
		menu.setBackground(background);
		
		//button looks
		play.setPrefSize(150, 50);
		play.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		options.setPrefSize(150, 50);
		options.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		exit.setPrefSize(150, 50);
		exit.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		//adding event listeners to buttons
		play.setOnAction((event) -> {
			stage.setScene(createChess(stage));
		});
		
		exit.setOnAction((event) -> {
			stage.close();
		});
		
		//adding items to menu
		menu.getChildren().addAll(play,options,exit);
		
		
		//creating scene
		Scene scene = new Scene(menu, 960, 960);
		return scene;		
	}
	
	//creates chess board
	private Scene createChess(Stage stage) {
		board = new GridPane();
		fields = new Button[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				fields[i][j] = new Button();
				String color;
				if ((i + j) % 2 == 0) {
					color = "beige";
				} else {
					color = "darkslategrey";
				}
				
				//setUpPiece(fields[i][j]);
				
				fields[i][j].setStyle("-fx-background-color: " + color + ";");
				fields[i][j].setPrefSize(120, 120);
				board.add(fields[i][j], i, j);
			}
		}
		
		//moving pieces
		/*fields[0][0].setGraphic(new ImageView(B_Pawn));
		fields[0][0].setOnAction((event) -> {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					Button button = fields[i][j];
					button.setOnAction((event2) -> {
						movePiece(button);
						removePiece(fields[0][0]);
					});
				}
			}
		});*/
		
		Scene scene = new Scene(board);
		return scene;
	}
	
	private void setUpPiece(Button button) {
		button.setOnAction((event) -> {
			movePiece(button);
		});
	}
	
	private void movePiece(Button button) {
		button.setGraphic(new ImageView(B_Pawn));
	}
	
	private void removePiece(Button button) {
		button.setGraphic(null);
	}
	
}
