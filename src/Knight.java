
public class Knight extends Figure{

	public Knight(Coordinate cords, String color, String image) {
		super(cords, color, image);
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
