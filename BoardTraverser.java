public class BoardTraverser {
	Board board;
	
	public BoardTraverser(Board board){
		this.board = board;
	}
	
	public Triangle getFirstUnoccupiedTriangle(){
		Triangle currentTriangle = board.upperLeftCorner;
		while(!currentTriangle.isOccupied()){
			currentTriangle = getNextTriangle(currentTriangle);
			if(currentTriangle == null){
				return null;
			}
		}
		return currentTriangle;
	}
	
	public Triangle getNextTriangle(Triangle currentTriangle){

		if(currentTriangle.upwardPointing){
			if(hasTriangleDownLeft(currentTriangle)){ 
				currentTriangle = triangleDownLeft(currentTriangle);
				}
			else{                      currentTriangle = fromUpwardPointingToBegginingOfNextDiagonal(currentTriangle); }
		
		} else { // if triangle downwardPointing
			if(hasTriangleUpRight(currentTriangle)){ currentTriangle = triangleUpRight(currentTriangle); }
			else{                     currentTriangle = fromDownwardPointingToBegginingOfNextDiagonal(currentTriangle); }
		} 
		return currentTriangle;
		
	}
	
	private Triangle fromDownwardPointingToBegginingOfNextDiagonal(Triangle currentTriangle) {
		if(currentTriangle.hasSibling(Direction.RIGHT)){
			return currentTriangle.getTriangle(Direction.RIGHT);
		}
		return null;
	}
	
	private boolean hasTriangleUpRight(Triangle currentTriangle) {		
		if( currentTriangle.hasSibling(Direction.ABOVE) ){
			Triangle aboveTriangle = currentTriangle.getTriangle(Direction.ABOVE);	
			return aboveTriangle.hasSibling(Direction.RIGHT);
		} 
		return false;
	}
	
	private boolean hasTriangleDownLeft(Triangle currentTriangle) {		
		if(currentTriangle.getTriangle(Direction.BELOW) != null){
			Triangle belowTriangle = currentTriangle.getTriangle(Direction.BELOW);	
			return belowTriangle.getActiveDirections().contains(Direction.LEFT);
		} 
		return false;	
	}
	
	private Triangle triangleUpRight(Triangle currentTriangle) {
		return currentTriangle.getTriangle(Direction.ABOVE).getTriangle(Direction.RIGHT);
	}
	
	private Triangle triangleDownLeft(Triangle currentTriangle) {
		return currentTriangle.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT);
	}

	private Triangle fromUpwardPointingToBegginingOfNextDiagonal(Triangle currentTriangle) {
		if(currentTriangle.getActiveDirections().contains(Direction.BELOW)){
			return currentTriangle.getTriangle(Direction.BELOW);
		}else if(currentTriangle.getActiveDirections().contains(Direction.RIGHT)){
			return currentTriangle.getTriangle(Direction.RIGHT);
		}			
		return null;
	}


}
