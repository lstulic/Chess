
public class Pawn extends Figure{
	private boolean moved;

	public Pawn(Coordinate cords, String color, String image, String id) {
		super(cords, color, image, id);
		addMoves();
		this.moved = false;
	}
	
	public void addMoves() {
		if (super.getColor().equals("white")) {
			setMove(-1,0);
		} else {
			setMove(1,0);
		}
	}
	
	public boolean Moved() {
		return this.moved;
	}
	
	public void Move() {
		this.moved = true;
	}
}
