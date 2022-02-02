
public class Bishop extends Figure{

	public Bishop(Coordinate cords, String color, String image) {
		super(cords, color, image);
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
