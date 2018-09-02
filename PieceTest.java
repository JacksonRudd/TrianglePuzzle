
import org.junit.Before;
import org.junit.Test;

public class PieceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRotate() throws Exception {
		Board board = new Board();
		Piece duck = new MountainPiece();
		board.fillShapeAttemptSucceeds(duck,                 board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.RIGHT));
		board.print();
		duck.rotateRight();
		board.remove(duck);
		System.out.print(board.fillShapeAttemptSucceeds(duck, board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.RIGHT).getTriangle(Direction.BELOW)));
		board.print();
	}
//	
//	@Test
//	public void testDuck() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new Duck(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW));
//		System.out.print(success);
//		board.print();
//	}
//	
//	@Test
//	public void testMountain() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new MountainPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
//		System.out.print(success);
//		board.print();
//	}
//
//	@Test
//	public void testLine() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new LinePiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
//		System.out.print(success);
//		board.print();
//	}
//	
//	@Test
//	public void testHook() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new HookPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
//		System.out.print(success);
//		board.print();
//	}
//	@Test
//	public void testBoomerang() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new BoomerangPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
//		System.out.print(success);
//		board.print();
//	}
//	
//	@Test
//	public void testHourglass() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new HourGlassPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW));
//		System.out.print(success);
//		board.print();
//	}
//	
//	@Test
//	public void testCrown() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new CrownPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW));
//		System.out.print(success);
//		board.print();
//	}
//	@Test
//	public void testNike() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new NikeSwooshPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
//		System.out.print(success);
//		board.print();
//	}
//	@Test
//	public void TeetonsTest() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new TeetonsPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
//		System.out.print(success);
//		board.print();
//	}
//	@Test
//	public void DogTest() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new DogPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW));
//		System.out.print(success);
//		board.print();
//	}
//	@Test
//	public void BatTest() throws Exception {
//		Board board = new Board();
//		boolean success = board.fillShapeAttemptSucceeds(new BatPiece(), board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
//		System.out.print(success);
//		board.print();
//	}
}
