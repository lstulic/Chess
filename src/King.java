
public class King extends Figure{

	public King(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
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
