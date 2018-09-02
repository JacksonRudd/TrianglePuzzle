public class TeetonsPiece extends Piece {
	TeetonsPiece(){
		super();
		toChar = '2';
	}

	@Override
	public void createTriangleGraph() {
		upperLeftTriangle = Triangle.createUpwardPointing();
		upperLeftTriangle
			.createSiblingTriangle(Direction.BELOW)
			.createSiblingTriangle(Direction.LEFT)
			.getTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.ABOVE);
		
	}
}
