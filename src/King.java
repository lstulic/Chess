
public class King extends Figure{

	public King(Coordinate cords, String color, String image) {
		super(cords, color, image);
		addMoves();
	}
	
	public void addMoves() {
		setMove(0,1);
		setMove(0,-1);
		setMove(1,0);
		setMove(-1,0);
		setMove(1,1);
		setMove(-1,-1);
		setMove(-1,1);
		setMove(1,-1);
	}

}
