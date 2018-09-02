import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		BackTrackingSolution sol = new BackTrackingSolution();
		sol.board = board;
		sol.boardTraverser = new BoardTraverser(board);
		sol.notUsed = new HashSet<Piece>();
		sol.notUsed.add(new Octogon());
		sol.notUsed.add(new BatPiece());
		sol.notUsed.add(new MountainPiece());
		sol.notUsed.add(new BoomerangPiece());
		sol.notUsed.add(new CrownPiece());
		sol.notUsed.add(new DogPiece());
		sol.notUsed.add(new Duck());
		sol.notUsed.add(new HookPiece());
		sol.notUsed.add(new HourGlassPiece());
		sol.notUsed.add(new LinePiece());
		sol.notUsed.add(new TeetonsPiece());
		sol.notUsed.add(new NikeSwooshPiece());
		sol.backtrack();

		
		
	}
}
