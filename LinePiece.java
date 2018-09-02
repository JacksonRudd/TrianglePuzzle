public class LinePiece extends Piece {
 public LinePiece(){
	super();
	toChar = '9';

 }

@Override
public void createTriangleGraph() {

	 upperLeftTriangle = Triangle.createUpwardPointing();
	 upperLeftTriangle
	 	.createSiblingTriangle(Direction.RIGHT)
	 	.createSiblingTriangle(Direction.RIGHT)
	 	.createSiblingTriangle(Direction.RIGHT)
	 	.createSiblingTriangle(Direction.RIGHT)
	 	.createSiblingTriangle(Direction.RIGHT);
	 	
	
}
}
