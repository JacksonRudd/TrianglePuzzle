public class DogPiece extends Piece{
	DogPiece(){
		super();
		toChar = '3';				
	}

	@Override
	public void createTriangleGraph() {
		upperLeftTriangle = Triangle.createDownwardPointing();
		upperLeftTriangle

			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.ABOVE)
			.createSiblingTriangle(Direction.RIGHT)
			.getTriangle(Direction.LEFT)
			.getTriangle(Direction.BELOW)
			.createSiblingTriangle(Direction.RIGHT);
		
	}
}
