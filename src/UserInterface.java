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
import java.util.ArrayList;

public class UserInterface extends Application{
	
	public String W_Pawn = "file:images/white_pawn.png";
	public String B_Pawn = "file:images/black_pawn.png";
	
	//declaring board and fields
	static GridPane board;
	static Button[][] fields;
	static int xM, yM;
	
	
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
				fields[j][i] = new Button();
				String color;
				if ((i + j) % 2 == 0) {
					color = "beige";
				} else {
					color = "darkslategrey";
				}
				
				
				fields[j][i].setStyle("-fx-background-color: " + color + ";");
				fields[j][i].setPrefSize(120, 120);
				board.add(fields[j][i], i, j);
			}
		}
		
		setUp();
		
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
	
	private void setUp() {
		for (int i = 0; i < 8; i++) {
			Figure pawnW = new Pawn(new Coordinate(6,i), "white", W_Pawn);
			setUpPiece(pawnW);
		}
		
		for (int i = 0; i < 8; i++) {
			Figure pawnB = new Pawn(new Coordinate(1,i), "black", B_Pawn);
			setUpPiece(pawnB);
		}
	}
	
	private void setUpPiece(Figure piece) {
		int x = piece.getCoordinates().getX();
		int y = piece.getCoordinates().getY();
		String color = piece.getColor();
		String pieceImage = piece.getImage();
		Button field = fields[x][y];
		field.setGraphic(new ImageView(pieceImage));
		field.setOnAction((event) -> {
			moves(piece);
		});
	}
	
	private void moves(Figure piece) {
		int x = piece.getCoordinates().getX();
		int y = piece.getCoordinates().getY();
		ArrayList<Coordinate> move = piece.getMoves();
		System.out.println(piece.getMoves());
		for(Coordinate c: move) {
			xM = c.getX() + x;
			yM = c.getY() + y;
			System.out.println(c.getX());
			System.out.println(c.getY());
			if (xM < 8 && xM > -1) {
				if (yM < 8 && yM > -1) {
					fields[xM][yM].setOnAction((event) -> {
						movePiece(fields[xM][yM], xM, yM, piece);
						removePiece(fields[x][y]);
						fields[x][y].setOnAction((event2) -> {
							moves(piece);
						});
					});
				}
			}
		}
	}
	
	private void movePiece(Button button, int x, int y, Figure piece) {
		button.setGraphic(new ImageView(piece.getImage()));
		piece.setCoordinates(x, y);
		button.setOnAction((event) -> {
			moves(piece);
		});
		
	}
	
	private void removePiece(Button button) {
		button.setGraphic(null);
	}
	
}
