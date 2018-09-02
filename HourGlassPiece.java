public class HourGlassPiece extends Piece{

	public HourGlassPiece(){
		super();
		toChar = '4';
	}

	@Override
	public void createTriangleGraph() {
		upperLeftTriangle=Triangle.createDownwardPointing();
		upperLeftTriangle
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.getTriangle(Direction.LEFT)
			.createSiblingTriangle(Direction.BELOW)
			.createSiblingTriangle(Direction.LEFT)
			.getTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT);
		
	}
}
