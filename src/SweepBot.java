
public class SweepBot {
	//TreeMap<> decisionTree = new<> TreeMap();
	//Tree tree = new Tree();
	int decision=2;
	int interference = 4;
	
	public String getCommand(Board board) {
	
		if(board.getLegalMoves()[decision])
		switch(decision) {
		case 0:
			return "up";
		case 1:
			return "down";
		case 2:
			return "right";
		case 3:
			return "left";
			
		default:
			return "quit";
		
		}
		else {
			decision = (decision+1)%4;
			return getCommand(board);
			
		}
		
			
	}
	
	public int interfere_rate (Board board) {
		if(board.getRoundCounter()%7==0)
			this.interference = (int) java.lang.Math.random()*6+1;
		
		return interference;
	}
	
	
	
	
}
