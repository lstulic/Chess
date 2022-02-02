import java.util.ArrayList;


public abstract class Figure {
	private Coordinate cords;
	private String color;
	private ArrayList<Coordinate> moves;
	private String image;
	
	public Figure(Coordinate cords, String color, String image) {
		this.cords = new Coordinate(cords.getX(), cords.getY());
		this.color = color;
		this.moves = new ArrayList<>();
		this.image = image;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setCoordinates(int x, int y) {
		this.cords.setX(x);
		this.cords.setY(y);
	}
	
	public Coordinate getCoordinates() {
		return this.cords;
	}
	
	public void setMove(int x, int y) {
		this.moves.add(new Coordinate(x,y));
	}
	
	public ArrayList<Coordinate> getMoves() {
		return this.moves;
	}
	
	public String getImage() {
		return this.image;
	}
	
	public abstract void addMoves();
}
