
public class Bishop extends Figure{

	public Bishop(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
		addMoves();
	}
	
	public void addMoves() {
		for (int i = 1; i < 8; i++) {
			setMove(i,i);
			setMove(-i,-i);
			setMove(i,-i);
			setMove(-i, i);
		}
	}
}
