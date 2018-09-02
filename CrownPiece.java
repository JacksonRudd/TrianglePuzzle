public class CrownPiece extends Piece{
	public CrownPiece(){
		super();
		toChar = 'A';



	}

	@Override
	public void createTriangleGraph() {

		upperLeftTriangle=Triangle.createDownwardPointing();
		upperLeftTriangle
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.ABOVE)
			.getTriangle(Direction.BELOW)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT);	
		
	}
}
