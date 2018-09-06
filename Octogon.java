public class Octogon extends Piece {
	
	int numberOfFlipOrientations = 1;
	int numberOfRotateOrientations = 1;
	public Octogon(){
		super();
		toChar = '5';

	}

	public void getNextOrientation() {
		return;
	}
	@Override
	public void createTriangleGraph() {
		this.upperLeftTriangle = Triangle.createUpwardPointing();
		try {
			upperLeftTriangle
				.setSiblingTriangle(Direction.RIGHT, Triangle.createDownwardPointing())
				.setSiblingTriangle(Direction.RIGHT, Triangle.createUpwardPointing())
				.setSiblingTriangle(Direction.BELOW, Triangle.createDownwardPointing())
				.setSiblingTriangle(Direction.LEFT , Triangle.createUpwardPointing())
				.setSiblingTriangle(Direction.LEFT , Triangle.createDownwardPointing());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}


}
