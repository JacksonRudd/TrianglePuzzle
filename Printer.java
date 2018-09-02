public class Printer {

	public static void printBoard(Board board){
		Triangle index = board.upperLeftCorner;
		printRow(index);
		for(int i = 1; i< 6;i++){
			index = index.getTriangle(Direction.BELOW).getTriangle(Direction.LEFT);
			printRow(index);
		}
			index = index.getTriangle(Direction.BELOW);
			printRow(index);
			index = index.getTriangle(Direction.RIGHT).getTriangle(Direction.BELOW);
			printRow(index);	
	}

	private static void printRow(Triangle leftMost){
			for(int row = 0; row<3;row++)	{
				Triangle index = leftMost;

				System.out.println();
				
				//prints half triangles
				for(int i = 0; i<15-(totalTrianglesInRow(leftMost)-1)/2  ;i++){System.out.print("    ");}
				
				if(index.upwardPointing){for(int i = 0; i<2-row ;i++){System.out.print(" ");}}
				if(!index.upwardPointing){for(int i = 0; i<row ;i++){System.out.print(" ");}System.out.print("\\");}
				
				while(true){
					if(index.upwardPointing){
						System.out.print("/");
						for(int i = 0; i<1+2*row ;i++){System.out.print(index.toChar());}
						System.out.print("\\");
						
					}else{
						for(int i = 0; i<5-2*row ;i++){System.out.print(index.toChar());}
					}
					if( index.hasSibling(Direction.RIGHT) ){ index = index.getTriangle(Direction.RIGHT); }
					else{ break; }
					
				}
			}

		
	}
	
	 static int totalTrianglesInRow(Triangle leftMost){
		int answer = 1;
		Triangle index = leftMost;
		while(index.hasSibling(Direction.RIGHT)){
				answer = answer+1;
			
			index = index.getTriangle(Direction.RIGHT);
		}
		return answer;
		
	}
	

}
