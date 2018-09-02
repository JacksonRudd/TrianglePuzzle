public class BatPiece extends Piece{
	public BatPiece(){
		super();
		toChar = '6';
	}

	@Override
	public void createTriangleGraph() {
		upperLeftTriangle = Triangle.createUpwardPointing();
		upperLeftTriangle
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.ABOVE)
			.createSiblingTriangle(Direction.RIGHT);
		
	}
}
