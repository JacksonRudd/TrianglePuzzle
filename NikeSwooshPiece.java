public class NikeSwooshPiece extends Piece{
	int numberOfFlipOrientations = 1;
	NikeSwooshPiece(){
		super();
		toChar = 'N';
	}

	@Override
	public void createTriangleGraph() {
		upperLeftTriangle = Triangle.createUpwardPointing();
		upperLeftTriangle	
			.createSiblingTriangle(Direction.RIGHT)
			.getTriangle(Direction.LEFT)
			.createSiblingTriangle(Direction.BELOW)
			.createSiblingTriangle(Direction.LEFT)
			.getTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT);
		
	}
}
