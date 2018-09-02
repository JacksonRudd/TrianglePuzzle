import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMoveOctogon() throws Exception {
		Board board = new Board();
		Printer.printBoard(board);
		Octogon oct = new Octogon();

		board.fillShapeAttemptSucceeds(oct, board.upperLeftCorner);
		Printer.printBoard(board);

		board.remove(oct);
		board.fillShapeAttemptSucceeds(oct, board.upperLeftCorner.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT).getTriangle(Direction.BELOW).getTriangle(Direction.LEFT));
		Printer.printBoard(board);
		board.remove(oct);


	}
	@Test
	public void testPlaceOctogonOffBoard() throws Exception {
		Board board = new Board();
		Octogon oct = new Octogon();

	
		boolean success = board.fillShapeAttemptSucceeds(oct, board.upperLeftCorner.getTriangle(Direction.RIGHT) );
		assertEquals(success, false);

	}
	@Test
	public void testPlaceOnOtherOctogon() throws Exception {
		Board board = new Board();
		Octogon oct = new Octogon();
		Octogon nativeOct = new Octogon();
		board.fillShapeAttemptSucceeds(nativeOct, board.upperLeftCorner );

		boolean success = board.fillShapeAttemptSucceeds(oct, board.upperLeftCorner );
		assertEquals(success, false);

	}

}
