
public class Pawn extends Figure{

	public Pawn(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
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
