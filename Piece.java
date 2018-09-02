import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public abstract class Piece {
	Triangle upperLeftTriangle;
	char toChar;
	Set<Triangle> allTriangles;
	private int orientation = 0;
	
	public Piece(){
		createTriangleGraph();
		addTrianglesToSet();
	}
	public abstract void createTriangleGraph();
	
	public Triangle getUpperLeftTriangle(){
		return upperLeftTriangle;
	}
	
	public void getNextOrientation() {
		
		orientation = (orientation + 1) % 10;
		rotateRight();
		if(orientation == 4 || orientation == 9){
			flip();
		}
	}
	
	private Piece flip() {
		for(Triangle t : allTriangles){
			t.flip();
		}
		upperLeftTriangle = getNewUpperLeft();
		return this;
		
	}
	public Piece rotateRight(){
		for(Triangle t : allTriangles){
			t.rotateRight();
		}
		upperLeftTriangle = getNewUpperLeft();
		return this;
	}
	private Triangle getNewUpperLeft() {
		Set<Triangle> visitedTriangles = new HashSet<Triangle>();
		
		Triangle me;
		int myUpperLeftiness;
		int myHeight;
		
		Stack<Triangle> toProcess = new Stack<Triangle>();
		Stack<Integer> heightOfToProcess = new Stack<Integer>();
		Stack<Integer> upperLeftinessOfToProcess = new Stack<Integer>();
		
		Triangle currentWinner = upperLeftTriangle;
		int currentWinnerUpperLeftiness = 0;
		int currentWinnerHeight = 0;
		
		toProcess.add(upperLeftTriangle);
		heightOfToProcess.add(0);
		upperLeftinessOfToProcess.add(0);
		
		
		while( !toProcess.empty() ){
			
			me = toProcess.pop();
			myUpperLeftiness = upperLeftinessOfToProcess.pop();
			myHeight = heightOfToProcess.pop();
			
			visitedTriangles.add(me);
			
			boolean iAmMoreUpperLeftThanWinner = myUpperLeftiness > currentWinnerUpperLeftiness;
			boolean iAmAsUpperLeftAsWinnerButAlsoTaller = myUpperLeftiness == currentWinnerUpperLeftiness && myHeight > currentWinnerHeight;
			boolean iAmNewWinner = iAmMoreUpperLeftThanWinner || iAmAsUpperLeftAsWinnerButAlsoTaller;
			if(iAmNewWinner){
				currentWinner = me;
				currentWinnerUpperLeftiness = myUpperLeftiness;
				currentWinnerHeight = myHeight;
			}
					
			if(me.hasSibling(Direction.ABOVE) && !visitedTriangles.contains(me.getTriangle(Direction.ABOVE))){
				toProcess.add(me.getTriangle(Direction.ABOVE));
				heightOfToProcess.add(myHeight + 1);
				upperLeftinessOfToProcess.add(myUpperLeftiness + 1);
			}
			if(me.hasSibling(Direction.BELOW) && !visitedTriangles.contains(me.getTriangle(Direction.BELOW))){
				toProcess.add(me.getTriangle(Direction.BELOW));
				heightOfToProcess.add(myHeight - 1);
				upperLeftinessOfToProcess.add(myUpperLeftiness - 1);
			}		
			if(me.hasSibling(Direction.RIGHT) && !visitedTriangles.contains(me.getTriangle(Direction.RIGHT))){
				toProcess.add(me.getTriangle(Direction.RIGHT));
				heightOfToProcess.add(myHeight);
				upperLeftinessOfToProcess.add(myUpperLeftiness - 1);
			}
			if(me.hasSibling(Direction.LEFT) && !visitedTriangles.contains(me.getTriangle(Direction.LEFT))){
				toProcess.add(me.getTriangle(Direction.LEFT));
				heightOfToProcess.add(myHeight);
				upperLeftinessOfToProcess.add(myUpperLeftiness + 1);
			}
		}
		return currentWinner;
	}
	

	public void addTrianglesToSet(){
		allTriangles = new HashSet<Triangle>();
		Queue<Triangle> toProcess = new LinkedList<Triangle>();
		toProcess.add(upperLeftTriangle);
		Triangle beingProcessed;
		while(toProcess.peek() != null){
			beingProcessed = toProcess.poll();
			allTriangles.add(beingProcessed);
			for(Direction dir: beingProcessed.getActiveDirections()){
				Triangle sibling = beingProcessed.getTriangle(dir);
				if(!allTriangles.contains(sibling)){
					toProcess.add(sibling);
				}
			}
		}
	}
		
	public boolean isFirstOrientation() {
		return orientation == 0;
	}

	public char toChar() {
		// TODO Auto-generated method stub
		return toChar;
	}

}
