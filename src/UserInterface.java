import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class UserInterface extends Application{
	
	
	
	public void start(Stage stage) {
		
		stage.setScene(createMenu(stage));
		stage.setTitle("Chess");
		stage.show();
	}
	
	public static void launch() {
		launch(UserInterface.class);
	}
	
	
	private Scene createMenu(Stage stage) {
		//creating items
		VBox menu = new VBox();
				
		Button play = new Button("Play");
		Button options = new Button("Options");
		Button exit = new Button("Exit");
		
		
		//adding image file and creating a background
		BackgroundImage backgroundImage = new BackgroundImage
				(new Image("file:design/chess.jpg"),
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
		Scene scene = new Scene(menu, 800, 800);
		return scene;		
	}
	
	
	private Scene createChess(Stage stage) {
		GridPane board = new GridPane();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				StackPane square = new StackPane();
				String color;
				if ((i + j) % 2 == 0) {
					color = "white";
				} else {
					color = "black";
				}
				
				square.setStyle("-fx-background-color: " + color + ";");
				square.setPrefSize(100, 100);
				board.add(square, i, j);
			}
		}
		
		Scene scene = new Scene(board);
		return scene;
	}
	
}
