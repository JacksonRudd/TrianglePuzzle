public class MountainPiece extends Piece{
	MountainPiece(){
		super();
		toChar = 'B';
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
			.createSiblingTriangle(Direction.RIGHT);
		
	}
}
