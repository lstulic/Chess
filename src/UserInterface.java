import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class UserInterface extends Application{
	
	public String W_Pawn = "file:images/white_pawn.png";
	public String W_Bishop = "file:images/white_bishop.png";
	public String W_Rook = "file:images/white_rook.png";
	public String W_Knight = "file:images/white_knight.png";
	public String W_King = "file:images/white_king.png";
	public String W_Queen = "file:images/white_queen.png";
	public String B_Pawn = "file:images/black_pawn.png";
	public String B_Bishop = "file:images/black_bishop.png";
	public String B_Rook = "file:images/black_rook.png";
	public String B_Knight = "file:images/black_knight.png";
	public String B_King = "file:images/black_king.png";
	public String B_Queen = "file:images/black_queen.png";
	
	
	//declaring board and fields
	static GridPane board;
	static Button[][] fields;
	HashMap<String, Figure> pieces = new HashMap<>();
	
	
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
		
		
		
		Scene scene = new Scene(board);
		return scene;
	}
	
	
	
	private void setUp() {
		for (int i = 0; i < 8; i++) {
			Figure pawnW = new Pawn(new Coordinate(6,i), "white", W_Pawn, "pawnW" + (i+1));
			pieces.put("pawnW" + (i+1),pawnW);
			
		}
		
		Figure leftBishopW = new Bishop(new Coordinate(7,2), "white", W_Bishop, "leftBishopW");
		pieces.put("leftBishopW", leftBishopW);
		
		Figure rightBishopW = new Bishop(new Coordinate(7,5), "white", W_Bishop, "rightBishopW");
		pieces.put("rightBishopW", rightBishopW);
		
		Figure leftRookW = new Rook(new Coordinate(7,0), "white", W_Rook, "leftRookW");
		pieces.put("leftRookW", leftRookW);
		
		Figure rightRookW = new Rook(new Coordinate(7,7), "white", W_Rook, "rightRookW");
		pieces.put("rightRookW", rightRookW);
		
		Figure leftKnightW = new Knight(new Coordinate(7,1), "white", W_Knight, "leftKnightW");
		pieces.put("leftKnightW", leftKnightW);

		Figure rightKnightW = new Knight(new Coordinate(7,6), "white", W_Knight, "rightKnightW");
		pieces.put("rightKnightW", rightKnightW);
		
		Figure queenW = new Queen(new Coordinate(7,3), "white", W_Queen, "queenW");
		pieces.put("queenW", queenW);
		
		Figure kingW = new King(new Coordinate(7,4), "white", W_King, "kingW");
		pieces.put("kingW", kingW);
		
		
		
		for (int i = 0; i < 8; i++) {
			Figure pawnB = new Pawn(new Coordinate(1,i), "black", B_Pawn, "pawnB" + (i+1));
			pieces.put("pawnB" + (i+1), pawnB);
		}
		
		Figure leftBishopB = new Bishop(new Coordinate(0,2), "black", B_Bishop, "leftBishopB");
		pieces.put("leftBishopB", leftBishopB);
		
		Figure rightBishopB = new Bishop(new Coordinate(0,5), "black", B_Bishop, "rightBishopB");
		pieces.put("rightBishopB", rightBishopB);
		
		Figure leftRookB = new Rook(new Coordinate(0,0), "black", B_Rook, "leftRookB");
		pieces.put("leftRookB", leftRookB);
		
		Figure rightRookB = new Rook(new Coordinate(0,7), "black", B_Rook, "rightRookB");
		pieces.put("rightRookB", rightRookB);
		
		Figure leftKnightB = new Knight(new Coordinate(0,1), "black", B_Knight, "leftKnightB");
		pieces.put("leftKnightB", leftKnightB);

		Figure rightKnightB = new Knight(new Coordinate(0,6), "black", B_Knight, "rightKnightB");
		pieces.put("rightKnightB", rightKnightB);
		
		Figure queenB = new Queen(new Coordinate(0,3), "black", B_Queen, "queenB");
		pieces.put("queenB", queenB);
		
		Figure kingB = new King(new Coordinate(0,4), "black", B_King, "kingB");
		pieces.put("kingB", kingB);
		
		for (Figure figure: pieces.values()) {
			setUpPiece(figure);
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
			String style = field.getStyle();
			field.setStyle(style + "-fx-border-color: red; -fx-border-width: 1 1 1 1;");
			moves(piece, style);
		});
	}
	
	
	
	private void moves(Figure piece, String style) {
		int x = piece.getCoordinates().getX();
		int y = piece.getCoordinates().getY();
		ArrayList<Coordinate> move = piece.getMoves();
		clearField();
		
		fields[x][y].setOnAction((event) -> {
			clearField();
			fields[x][y].setStyle(style);
			for (Figure figure: pieces.values()) {
				setUpPiece(figure);
			}
		});
		
		boolean knight = piece.getId().contains("Knight");
		boolean sameColor = false;
		
		
		for(Coordinate c: move) {
			int xx = c.getX() + x;
			int yy = c.getY() + y;
			int cgetX = c.getX();
			int cgetY = c.getY();
			
			
			if (xx < 8 && xx > -1) {
				if (yy < 8 && yy > -1) {
					if (!knight) {
						if (sameColor) {//collision
							if ((cgetX == 0 && cgetY == 1) || 
								(cgetX == 1 && cgetY == 0) || 
								(cgetX == 0 && cgetY == -1) ||
								(cgetX == -1 && cgetY == 0) ||
								(cgetX == 1 && cgetY == 1) ||
								(cgetX == -1 && cgetY == -1) ||
								(cgetX == -1 && cgetY == 1) ||
								(cgetX == 1 && cgetY == -1)) {
								sameColor = false;
							}
						}
					} else {
						sameColor = false;
					}
					if(!sameColor) {
						for (Figure figure: pieces.values()) {
							if (figure.getCoordinates().getX() == xx) {
								if (figure.getCoordinates().getY() == yy) {
									if (figure.getColor().equals(piece.getColor())) {
										sameColor = true;
									}
									if (figure.getId().contains("king")) {
										sameColor = true;
									}
								}
							}
							
						}
					}
					
					if (!sameColor) {
						setMove(fields[xx][yy], x, y, xx, yy, piece, style);
					}
				}
			}
		}
	}
	
	
	
	public void setMove(Button button, int x, int y, int xx, int yy, Figure piece, String style) {
		fields[xx][yy].setOnAction((event) -> {
			movePiece(fields[xx][yy], xx, yy, piece);
			removePiece(fields[x][y]);
			fields[x][y].setStyle(style);
		});
	}
	
	
	
	private void movePiece(Button button, int x, int y, Figure piece) {
		button.setGraphic(new ImageView(piece.getImage()));
		String id;
		for (Figure figure: pieces.values()) {
			if (figure.getCoordinates().getX() == x) {
				if (figure.getCoordinates().getY() == y) {
					id = figure.getId();
					pieces.remove(id);
					break;
				}
			}
		}
		

		piece.setCoordinates(x, y);
		clearField();
		for (Figure figure: pieces.values()) {
			setUpPiece(figure);
		}
	}
	
	
	
	private void removePiece(Button button) {
		button.setGraphic(null);
	}
	
	
	
	private void clearField() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				fields[i][j].setOnAction((event) -> {
					
				});
			}
		}
	}
	
}
