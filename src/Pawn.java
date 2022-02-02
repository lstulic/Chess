
public class Pawn extends Figure{

	public Pawn(Coordinate cords, String color, String image) {
		super(cords, color, image);
		addMoves();
	}
	
	public void addMoves() {
		if (super.getColor().equals("white")) {
			setMove(-1,0);
		} else {
			setMove(1,0);
		}
	}
}
