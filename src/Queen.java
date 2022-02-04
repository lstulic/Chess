
public class Queen extends Figure{

	public Queen(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
		addMoves();
	}
	
	public void addMoves() {
		for (int i = 1; i < 8; i++) {
			setMove(0,i);
			setMove(0,-i);
			setMove(i,0);
			setMove(-i,0);
			setMove(i,i);
			setMove(-i,-i);
			setMove(-i,i);
			setMove(i,-i);
		}
	}
}
