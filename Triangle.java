
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Triangle {
	boolean upwardPointing;
	Map<Direction, Triangle> map = new HashMap<Direction, Triangle>();
	Piece resident; 
	
	public char toChar(){
		if(resident == null){
			return '0';
		}
		return resident.toChar();
	}
	
	public static Triangle createUpwardPointing() {
		return new Triangle(true);
	}

	public static Triangle createDownwardPointing() {
		return new Triangle(false);
	}

	private Triangle(boolean b) {	
		upwardPointing = b;
	}


	
	public void addAboveSibling(Triangle above) throws Exception{
		if(above.upwardPointing == false || this.upwardPointing == true){
			throw new Exception();
		}
		this.setSiblingTriangle(Direction.ABOVE, above);
		above.setSiblingTriangle(Direction.BELOW, this);

	}
	

	
	public void setResident(Piece piece) {
		resident = piece;	
	}

	public boolean isOccupied() {
		return (resident == null);
	}

	public Set<Direction> getActiveDirections() {
		return map.keySet();
	}

	public Triangle getTriangle(Direction DIR) {
		return map.get(DIR);
	}
	
	public boolean hasSibling(Direction DIR){
		return getActiveDirections().contains(DIR);
	}
	
	public void deleteSibling(Direction DIR){
		map.remove(DIR);
	}

	public Triangle setSiblingTriangle(Direction DIR, Triangle t) throws Exception{
		if((upwardPointing && DIR == Direction.ABOVE) || (!upwardPointing && DIR == Direction.BELOW)){
			throw new Exception();
		}
		map.put(DIR, t);
		Direction opposite = Direction.opposite(DIR);
		if(t.getTriangle(opposite) != this){
				t.setSiblingTriangle(opposite, this);
		}
		return t;
	}
	
	public Triangle createSiblingTriangle(Direction DIR){
		Triangle toAdd;
		if(upwardPointing){toAdd = createDownwardPointing();}else{toAdd = createUpwardPointing();} 
		
		try{		return setSiblingTriangle(DIR, toAdd);
		} catch(Exception e) {return null;}
	}

	public void rotateRight() {
		Triangle left = map.get(Direction.LEFT);
		Triangle right = map.get(Direction.RIGHT);
		if(upwardPointing){
			Triangle below = map.get(Direction.BELOW);
			map.put(Direction.LEFT, below);
			map.put(Direction.ABOVE, left);
			map.put(Direction.RIGHT, right);
			map.remove(Direction.BELOW);
			upwardPointing = false;
			
		}else{

			Triangle above = map.get(Direction.ABOVE);
			map.put(Direction.LEFT, left);
			map.put(Direction.BELOW, right);
			map.put(Direction.RIGHT, above);
			map.remove(Direction.ABOVE);
			upwardPointing = true;
		}
		for(Direction d : Direction.values()){
			if(map.get(d) == null){
				map.remove(d);
			}
		}
		
	}

	public void flip() {
		Triangle left = map.get(Direction.LEFT);
		Triangle right = map.get(Direction.RIGHT);
		map.put(Direction.RIGHT, left);
		map.put(Direction.LEFT, right);
		for(Direction d : Direction.values()){
			if(map.get(d) == null){
				map.remove(d);
			}
		}
		
	}

}
