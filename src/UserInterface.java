import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
		BorderPane bp = new BorderPane();
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
		exit.setOnAction((event) -> {
			stage.close();
		});
		
		//adding items to menu
		menu.getChildren().addAll(play,options,exit);
		
		
		//creating scene
		Scene scene = new Scene(menu, 800, 800);
		return scene;		
	}
}
