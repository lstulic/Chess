
public abstract class Figure {
	private Coordinate cords;
	private String color;
	
	public Figure(Coordinate cords, String color) {
		this.cords = new Coordinate(cords.getX(), cords.getY());
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Coordinate getCoordinate() {
		return this.cords;
	}
	
}
