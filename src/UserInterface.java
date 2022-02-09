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
	static HashMap<String, Figure> pieces = new HashMap<>();
	public boolean firstMove = true;
	public String picked;
	public int newId = 1;
	
	
	
	
	
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
			boolean hasPiece = false;
			boolean hadPiece = false;
			boolean Piece = false;
		
		
			for(Coordinate c: move) {
				int xx = c.getX() + x;
				int yy = c.getY() + y;
				int cgetX = c.getX();
				int cgetY = c.getY();
			
			
				if (xx < 8 && xx > -1) {
					if (yy < 8 && yy > -1) {
						if (!knight) {
							if (sameColor || hasPiece) {//collision
								if ((cgetX == 0 && cgetY == 1) || 
									(cgetX == 1 && cgetY == 0) || 
									(cgetX == 0 && cgetY == -1) ||
									(cgetX == -1 && cgetY == 0) ||
									(cgetX == 1 && cgetY == 1) ||
									(cgetX == -1 && cgetY == -1) ||
									(cgetX == -1 && cgetY == 1) ||
									(cgetX == 1 && cgetY == -1)) {
									sameColor = false;
									hadPiece = false;
									hasPiece = false;
								}
							}
						} else {
							sameColor = false;
							hadPiece = false;
							hasPiece = false;
						}
						if(!sameColor) {
							for (Figure figure: pieces.values()) {
								if (figure.getCoordinates().getX() == xx) {
									if (figure.getCoordinates().getY() == yy) {
										if (figure.getColor().equals(piece.getColor())) {
											sameColor = true;
										} else {
											hadPiece = true;
											Piece = true;
										}
										if (figure.getId().contains("king")) {
											sameColor = true;
										}
									}
								}
								
							}
						}
						
						if (!sameColor && !hasPiece) {
							if (piece.getId().contains("pawn")) {
								if (!Piece) {
									setMove(fields[xx][yy], x, y, xx, yy, piece, style);
								}
							} else if(hadPiece){
								setMove(fields[xx][yy], x, y, xx, yy, piece, style);
								hasPiece = true;
							} else {
								setMove(fields[xx][yy], x, y, xx, yy, piece, style);
							}
						}
						
					}
				}
			}
			
			if (piece.getId().contains("pawn")) {
				pawnMoves(piece, style);
			}
			
			if (piece.getId().contains("king")) {
				King king = (King) piece;
				if (!king.getMoved()) {
					castling(piece, style);
				}
			}
		
		
		
	}
	
	
	
	private void pawnMoves(Figure piece, String style) {
		int x = piece.getCoordinates().getX();
		int y = piece.getCoordinates().getY();
		
		boolean sameColor = false;
		if (piece.getId().contains("pawnW")) {
			for (Figure figure: pieces.values()) {
				if (figure.getCoordinates().getX() == x-1) {
					if (figure.getCoordinates().getY() == y-1) {
						if (!figure.getColor().equals(piece.getColor())) {
							if (!figure.getId().contains("king")) {
								setMove(fields[x-1][y-1], x, y, x-1, y-1, piece, style);
							}
						}
					}
				}
				if (figure.getCoordinates().getX() == x-1) {
					if (figure.getCoordinates().getY() == y+1) {
						if (!figure.getColor().equals(piece.getColor())) {
							if (!figure.getId().contains("king")) {
								setMove(fields[x-1][y+1], x, y, x-1, y+1, piece, style);
							}
						}
					}
				}
			}
		} else {
			for (Figure figure: pieces.values()) {
				if (figure.getCoordinates().getX() == x+1) {
					if (figure.getCoordinates().getY() == y+1) {
						if (!figure.getColor().equals(piece.getColor())) {
							if (!figure.getId().contains("king")) {
								setMove(fields[x+1][y+1], x, y, x+1, y+1, piece, style);
							}
						}
					}
				}
				if (figure.getCoordinates().getX() == x+1) {
					if (figure.getCoordinates().getY() == y-1) {
						if (!figure.getColor().equals(piece.getColor())) {
							if (!figure.getId().contains("king")) {
								setMove(fields[x+1][y-1], x, y, x+1, y-1, piece, style);
							}
						}
					}
				}
			}
		}
		
	}
	
	
	
	private void setMove(Button button, int x, int y, int xx, int yy, Figure piece, String style) {
		if (piece.getId().contains("pawnW")) {
			Pawn pieceP = (Pawn) piece;
			if (!pieceP.Moved()) {
				fields[xx-1][yy].setOnAction((event) -> {
					movePiece(fields[xx-1][yy], xx-1, yy, piece);
					removePiece(fields[x][y]);
					fields[x][y].setStyle(style);
					pieceP.Move();
				});
				fields[xx][yy].setOnAction((event) -> {
					movePiece(fields[xx][yy], xx, yy, piece);
					removePiece(fields[x][y]);
					fields[x][y].setStyle(style);
					pieceP.Move();
				});
			} else {
				fields[xx][yy].setOnAction((event) -> {
					movePiece(fields[xx][yy], xx, yy, piece);
					removePiece(fields[x][y]);
					fields[x][y].setStyle(style);
					pieceP.Move();
				});
			}
			
		} else if(piece.getId().contains("pawnB")) {
			Pawn pieceP = (Pawn) piece;
			if (!pieceP.Moved()) {
				fields[xx+1][yy].setOnAction((event) -> {
					movePiece(fields[xx+1][yy], xx+1, yy, piece);
					removePiece(fields[x][y]);
					fields[x][y].setStyle(style);
					pieceP.Move();
				});
				fields[xx][yy].setOnAction((event) -> {
					movePiece(fields[xx][yy], xx, yy, piece);
					removePiece(fields[x][y]);
					fields[x][y].setStyle(style);
					pieceP.Move();
				});
			} else {
				fields[xx][yy].setOnAction((event) -> {
					movePiece(fields[xx][yy], xx, yy, piece);
					removePiece(fields[x][y]);
					fields[x][y].setStyle(style);
				});
			}
			
		}else {
			fields[xx][yy].setOnAction((event) -> {
				movePiece(fields[xx][yy], xx, yy, piece);
				removePiece(fields[x][y]);
				fields[x][y].setStyle(style);
				if (piece.getId().contains("king")) {
					King king = (King) piece;
					king.setMoved();
				} else if (piece.getId().contains("Rook")) {
					Rook rook = (Rook) piece;
					rook.setMoved();
				}
			});
		}
		
		
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
		
		if (piece.getId().contains("pawn")) {
			checkPawnLocation(piece);
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
	
	
	
	private void checkPawnLocation(Figure piece) {
		String id = "";
		if (piece.getCoordinates().getX() == 0) {
			id = piece.getId();
			Stage stage2 = new Stage();
			PickPawn(stage2, piece.getColor(),  piece);
		}
		
		if (piece.getCoordinates().getX() == 7) {
			id = piece.getId();
			Stage stage2 = new Stage();
			PickPawn(stage2, piece.getColor(),  piece);
		}
	}
	
	
	
	private void PickPawn(Stage stage2, String color, Figure piece) {
		HBox hb = new HBox();
		Button bishop = new Button();
		Button rook = new Button();
		Button knight = new Button();
		Button queen = new Button();
		
		
		
		
		bishop.setPrefSize(120, 120);
		rook.setPrefSize(120, 120);
		knight.setPrefSize(120, 120);
		queen.setPrefSize(120, 120);
		
		bishop.setStyle("-fx-background-color: beige;");
		rook.setStyle("-fx-background-color: darkslategrey;");
		knight.setStyle("-fx-background-color: beige;");
		queen.setStyle("-fx-background-color: darkslategrey;");
		
		
		if (color.equals("white")) {
			bishop.setGraphic(new ImageView(W_Bishop));
			rook.setGraphic(new ImageView(W_Rook));
			knight.setGraphic(new ImageView(W_Knight));
			queen.setGraphic(new ImageView(W_Queen));
		} else if (color.equals("black")) {
			bishop.setGraphic(new ImageView(B_Bishop));
			rook.setGraphic(new ImageView(B_Rook));
			knight.setGraphic(new ImageView(B_Knight));
			queen.setGraphic(new ImageView(B_Queen));
		}
		
		
		bishop.setOnAction((event) -> {
			System.out.println("bishop");
			setNewPiece(color, piece.getCoordinates().getX(), piece.getCoordinates().getY(), piece.getId(), "bishop");
			stage2.close();
		});
		
		rook.setOnAction((event) -> {
			System.out.println("rook");
			setNewPiece(color, piece.getCoordinates().getX(), piece.getCoordinates().getY(), piece.getId(), "rook");
			stage2.close();
		});
		
		knight.setOnAction((event) -> {
			System.out.println("knight");
			setNewPiece(color, piece.getCoordinates().getX(), piece.getCoordinates().getY(), piece.getId(), "knight");
			stage2.close();
		});
		
		queen.setOnAction((event) -> {
			System.out.println("queen");
			setNewPiece(color, piece.getCoordinates().getX(), piece.getCoordinates().getY(), piece.getId(), "queen");
			stage2.close();
		});
		
		
		
		hb.getChildren().addAll(bishop, rook, knight, queen);
		
		Scene scene = new Scene(hb);
		stage2.setScene(scene);
		stage2.show();
	}
	
	private void setNewPiece(String color, int x, int y, String id, String piece) {
		Figure newFigure = new Pawn(new Coordinate(x, y), color, W_Pawn, id);
		if (color.equals("white")) {
			switch(piece) {
			case "bishop":
				newFigure = new Bishop(new Coordinate(x, y), color, W_Bishop, "BishopW" + newId++);
				break;
			case "rook":
				newFigure = new Rook(new Coordinate(x, y), color, W_Rook, "RookW" + newId++);
				break;
			case "knight":
				newFigure = new Knight(new Coordinate(x, y), color, W_Knight, "KnightW" + newId++);
				break;
			case "queen":
				newFigure = new Queen(new Coordinate(x, y), color, W_Queen, "QueenW" + newId++);
				break;
			}
		} else {
			switch(piece) {
			case "bishop":
				newFigure = new Bishop(new Coordinate(x, y), color, B_Bishop, "BishopB" + newId++);
				break;
			case "rook":
				newFigure = new Rook(new Coordinate(x, y), color, B_Rook, "RookB" + newId++);
				break;
			case "knight":
				newFigure = new Knight(new Coordinate(x, y), color, B_Knight, "KnightB" + newId++);
				break;
			case "queen":
				newFigure = new Queen(new Coordinate(x, y), color, B_Queen, "QueenB" + newId++);
				break;
			}
			
		}
		
		pieces.remove(id);
		pieces.put(newFigure.getId(), newFigure);
		
		clearField();
		for (Figure figure: pieces.values()) {
			setUpPiece(figure);
		}
	}
	
	
	
	private void castling(Figure piece, String style) {
		boolean hasPiece = false, hasRook = false;
		int x = piece.getCoordinates().getX();
		int y = piece.getCoordinates().getY();
			
		
		for (Figure figure: pieces.values()) {
			if (figure.getCoordinates().getX() == x && figure.getCoordinates().getY() == 5) {
				hasPiece = true;
				break;
			} else if (figure.getCoordinates().getX() == x && figure.getCoordinates().getY() == 6) {
				hasPiece = true;
				break;
			}
			
			if (figure.getCoordinates().getX() == x && figure.getCoordinates().getY() == 7) {
				if (figure.getId().contains("Rook")) {
					Rook rook = (Rook) figure;
					if (!rook.getMoved())
					{
						hasRook = true;
					}
				}
			}
		}
			
		if (!hasPiece && hasRook) {
			fields[x][6].setOnAction((event) -> {
				movePiece(fields[x][6], x, 6, piece);
				removePiece(fields[x][y]);
				fields[x][y].setStyle(style);
				if (piece.getColor().equals("white")) {
					movePiece(fields[x][5], x, 5, pieces.get("rightRookW"));
					removePiece(fields[x][7]);
					fields[x][7].setStyle(fields[x][7].getStyle());
					Rook rook = (Rook) pieces.get("rightRookW");
					rook.setMoved();
				} else {
					movePiece(fields[x][5], x, 5, pieces.get("rightRookB"));
					removePiece(fields[x][7]);
					fields[x][7].setStyle(fields[x][7].getStyle());
					Rook rook = (Rook) pieces.get("rightRookB");
					rook.setMoved();
				}
				King king = (King) piece;
				king.setMoved();
			});
		}
		
		hasPiece = false;
		hasRook = false;
		
		
		
		for (Figure figure: pieces.values()) {
			if (figure.getCoordinates().getX() == x && figure.getCoordinates().getY() == 3) {
				hasPiece = true;
				break;
			} else if (figure.getCoordinates().getX() == x && figure.getCoordinates().getY() == 2) {
				hasPiece = true;
				break;
			} else if (figure.getCoordinates().getX() == x && figure.getCoordinates().getY() == 1) {
				hasPiece = true;
				break;
			}
			
			if (figure.getCoordinates().getX() == x && figure.getCoordinates().getY() == 0) {
				if (figure.getId().contains("Rook")) {
					Rook rook = (Rook) figure;
					if (!rook.getMoved())
					{
						hasRook = true;
					}
				}
			}
		}
			
		if (!hasPiece && hasRook) {
			fields[x][2].setOnAction((event) -> {
				movePiece(fields[x][2], x, 2, piece);
				removePiece(fields[x][y]);
				fields[x][y].setStyle(style);
				if (piece.getColor().equals("white")) {
					movePiece(fields[x][3], x, 3, pieces.get("leftRookW"));
					removePiece(fields[x][0]);
					fields[x][0].setStyle(fields[x][0].getStyle());
					Rook rook = (Rook) pieces.get("leftRookW");
					rook.setMoved();
				} else {
					movePiece(fields[x][3], x, 3, pieces.get("leftRookB"));
					removePiece(fields[x][0]);
					fields[x][0].setStyle(fields[x][0].getStyle());
					Rook rook = (Rook) pieces.get("leftRookB");
					rook.setMoved();
				}
				King king = (King) piece;
				king.setMoved();
			});
			return;
		}
			
			
			
	}
	
}












