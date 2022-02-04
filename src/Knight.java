
public class Knight extends Figure{

	public Knight(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
		addMoves();
	}
	
	public void addMoves() {
		setMove(1,2);
		setMove(-1,2);
		setMove(1,-2);
		setMove(-1,-2);
		setMove(2,1);
		setMove(-2,1);
		setMove(2,-1);
		setMove(-2,-1);
	}

}
