import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Board {
	Map<Piece,Set<Triangle>> piecesMap = new HashMap<Piece,Set<Triangle>>();
	final Triangle upperLeftCorner;

	public Board() {
		Triangle highestPoint = tipOfEquilateralTriangleWithNineRows();
        
        //delete tip of triangle
        Triangle middleTop = highestPoint.getTriangle(Direction.BELOW);
        middleTop.deleteSibling(Direction.ABOVE);
        upperLeftCorner = middleTop.getTriangle(Direction.LEFT);
        
        //delete left corner
        Triangle upwardFacingSixDownOnLeft = upperLeftCorner;
        for(int i =2; i<=6;i++){
        	upwardFacingSixDownOnLeft = 
        			upwardFacingSixDownOnLeft.getTriangle(Direction.BELOW)
        			.getTriangle(Direction.LEFT);
        }
        upwardFacingSixDownOnLeft.getTriangle(Direction.BELOW).deleteSibling(Direction.LEFT);
        upwardFacingSixDownOnLeft.getTriangle(Direction.BELOW)
        	.getTriangle(Direction.RIGHT)
        	.getTriangle(Direction.BELOW)
        	.deleteSibling(Direction.LEFT);
        
        //delete right corner
        Triangle upwardFacingSixDownOnRight = upperLeftCorner.getTriangle(Direction.RIGHT).getTriangle(Direction.RIGHT);
        for(int i =2; i<=6;i++){
        	upwardFacingSixDownOnRight = 
        			upwardFacingSixDownOnRight.getTriangle(Direction.BELOW)
        			.getTriangle(Direction.RIGHT);
        }
        upwardFacingSixDownOnRight.getTriangle(Direction.BELOW).deleteSibling(Direction.RIGHT);
        upwardFacingSixDownOnRight.getTriangle(Direction.BELOW)
        	.getTriangle(Direction.LEFT)
        	.getTriangle(Direction.BELOW)
        	.deleteSibling(Direction.RIGHT);
        
	}

	public void print() {
		Printer.printBoard(this);
	}

	public void remove(Piece piece) {
		for(Triangle tri : piecesMap.get(piece)){
			tri.setResident(null);
		}
		piecesMap.remove(piece);
		
	}

	public boolean fillShapeAttemptSucceeds(Piece piece, Triangle boardTri) throws Exception{

        if (this.piecesMap.containsKey(piece)){
             throw new Exception();
        }

        piecesMap.put(piece, new HashSet<Triangle>());
        Set<Triangle> visitedTriangles = piecesMap.get(piece);

        Queue<Triangle> boardQueue = new LinkedList<Triangle>();
        Queue<Triangle> shapeQueue = new LinkedList<Triangle>();
        
        //breadth first search on board and shape requires two queues
        boardQueue.add(boardTri);
        shapeQueue.add(piece.upperLeftTriangle);

        while(!shapeQueue.isEmpty()){
        	Triangle shapeTri = shapeQueue.poll();
	        boardTri = boardQueue.poll();
	        
	        //if boardTriangle is already visited, continue
	        if(visitedTriangles.contains(boardTri)){continue;}
	       
	        //if boardTriangle is occupied, revert and fail
	        if(boardTri.resident != null){ 

	        	this.remove(piece); 
	        	return false ;
	        }
	        
	        //success, update triangle on the board
	        boardTri.setResident(piece);
	        visitedTriangles.add(boardTri);
		    
	        //continue loop
	        for(Direction DIR : shapeTri.getActiveDirections() ){
	        	//if the triangle goes off the board, then fail
		    	 if(boardTri.getTriangle(DIR) == null){
	                 this.remove(piece); 
	                 return false;
	            }else{
	                 boardQueue.add(boardTri.getTriangle(DIR));
	                 shapeQueue.add(shapeTri.getTriangle(DIR));
	            }
		
		      }

		}
		return true;
	}

	private Triangle tipOfEquilateralTriangleWithNineRows() {
        //queue of upwardPointing Triangles from last row
        Queue<Triangle> lastQueue = new LinkedList<Triangle>();
        
        //builds lastQueue as we process new row
        Queue<Triangle> thisQueue = new LinkedList<Triangle>();
        
        //create first row
        Triangle highestPoint = Triangle.createUpwardPointing();
        lastQueue.add(highestPoint);
        
        //creates second through ninth row
        for(int i =2; i <= 9; i++){
          Triangle left = Triangle.createUpwardPointing();
          while(!(lastQueue.peek() == null)){
        	thisQueue.add(left);
        	Triangle upwardPointingFromLastRow = lastQueue.poll();
            //triangle below upwardPointingFromLastRow
        	Triangle downwardFacing = Triangle.createDownwardPointing();
            try{
        	downwardFacing.addAboveSibling(upwardPointingFromLastRow);
            //add last triangles right triangle to the left create a new triangle on the right
            upwardPointingFromLastRow.getTriangle(Direction.BELOW)
            	.setSiblingTriangle(Direction.LEFT,  left); 
            left = upwardPointingFromLastRow.getTriangle(Direction.BELOW)
            	.setSiblingTriangle(Direction.RIGHT, Triangle.createUpwardPointing()); 
            }catch(Exception e){
            	
            }
          }
          //left is now the farthest right
          thisQueue.add(left);
          
          lastQueue =  thisQueue;
          thisQueue = new LinkedList<Triangle>();
        }
        return highestPoint;
	}
}