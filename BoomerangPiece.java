public class BoomerangPiece extends Piece {
	BoomerangPiece(){
		super();
		toChar = '1';


	}

	@Override
	public void createTriangleGraph() {
		upperLeftTriangle = Triangle.createUpwardPointing();
		upperLeftTriangle	
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.ABOVE)
			.createSiblingTriangle(Direction.LEFT);
		
	}
}
