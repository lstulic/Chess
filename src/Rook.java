
public class Rook extends Figure{

	public Rook(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
		addMoves();
	}
	
	public void addMoves() {
		for (int i = 1; i < 8; i++) {
			setMove(0,i);
			setMove(i,0);
			setMove(0,-i);
			setMove(-i,0);
		}
	}

}
