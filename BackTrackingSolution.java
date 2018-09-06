import java.util.HashSet;
import java.util.Set;

public class BackTrackingSolution{
	
	public Set<Piece> notUsed; 
	public Board board;
	public BoardTraverser boardTraverser;
	public int totalSolutions = 0;
	
	
	public void backtrack() throws Exception{
		if (this.isDone()){
			this.board.print();
			totalSolutions += 1;
			System.out.println("Now we have " + totalSolutions + " many solutions");
			return;
		}
		Set<Piece> tryThisTurn = new HashSet<Piece>(notUsed);
		
		for(Piece piece: tryThisTurn){

			do{
				if(board.fillShapeAttemptSucceeds(piece, boardTraverser.getFirstUnoccupiedTriangle() ) ){
					if(board.piecesMap.size() == 1){board.print();}
					notUsed.remove(piece);
					backtrack();
					board.remove(piece);
					notUsed.add(piece);
				}
				piece.getNextOrientation();
			}while(!piece.isFirstOrientation()); 
			
		}
		
	}

	private boolean isDone(){
		return notUsed.isEmpty();
		
		
	}

}
