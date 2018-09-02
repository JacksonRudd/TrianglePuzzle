public class HookPiece extends Piece{
	HookPiece(){
		super();
		toChar = '8';


	}

	@Override
	public void createTriangleGraph() {
		upperLeftTriangle = Triangle.createUpwardPointing();
		upperLeftTriangle
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.RIGHT)
			.createSiblingTriangle(Direction.BELOW);
		
	}
}
