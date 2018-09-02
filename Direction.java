
public enum Direction {
	ABOVE, BELOW,LEFT,RIGHT;

	public static Direction opposite(Direction d) {
		if(d == LEFT){return RIGHT;}
		if(d == RIGHT){return LEFT;}
		if(d == ABOVE){return BELOW;}
		if(d == BELOW){return ABOVE;}
		
		return null;
	}
}
