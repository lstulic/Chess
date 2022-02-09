
public class King extends Figure{
	
	private boolean moved;

	public King(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
		addMoves();
		this.moved = false;
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
	
	
	public boolean getMoved() {
		return this.moved;
	}
	
	public void setMoved() {
		this.moved = true;
	}

}