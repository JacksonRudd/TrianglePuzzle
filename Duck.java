public class Duck extends Piece{
		int numberOfRotateOrientations = 3;

		public Duck(){
			super();
			toChar = '7';

	
		}

		@Override
		public void createTriangleGraph() {
			upperLeftTriangle  = Triangle.createDownwardPointing();
			upperLeftTriangle
				.createSiblingTriangle(Direction.RIGHT)
				.createSiblingTriangle(Direction.RIGHT)
				.createSiblingTriangle(Direction.ABOVE)
				.createSiblingTriangle(Direction.RIGHT)
				.createSiblingTriangle(Direction.RIGHT);
			
		}
}
