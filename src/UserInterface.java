import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class UserInterface extends Application{
	
	
	
	public void start(Stage stage) {
		//creating items
		VBox menu = new VBox();
		
		Button play = new Button("Play");
		Button options = new Button("Options");
		Button exit = new Button("Exit");
		
		
		//menu looks
		menu.setSpacing(10);
		menu.setAlignment(Pos.CENTER);
		
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
		
		
		//creating scene and adding it to stage
		Scene scene = new Scene(menu, 400, 400);
		stage.setScene(scene);
		stage.setTitle("Chess");
		stage.show();
	}
	
	public static void launch() {
		launch(UserInterface.class);
	}
}
