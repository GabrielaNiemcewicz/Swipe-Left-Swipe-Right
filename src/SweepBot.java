import java.util.TreeSet;

public class SweepBot {
	//TreeMap<> decisionTree = new<> TreeMap();
	//Tree tree = new Tree();
	int decision;
	int interference;
	TreeSet<Node> decisionTree;
	
	SweepBot(){
		 decision=0;
		 interference = 2;
		 decisionTree = new TreeSet<Node>();
	}
	
	private void decide(RandomWalk memory, Board board) {
		if((!memory.isIn(board))&&(memory.peek2().equals("UNDO")));
		//
		
		
	}
	
	
	public String getCommand(Board board) {
		if(board.getLegalMoves()[this.decision])
		switch(decision) {
		case 0:
			return "up";
		case 1:
			return "down";
		case 2:
			return "right";
		case 3:
			return "left";
		case 4:
			return "undo";
			
		default:
			return "quit";
		
		}
		else {
			this.decision += 1;
			 if(decision==4)
				 this.decision = 0;
			return getCommand(board);
			
		}
		
			
	}
	
	public int interfere_rate (Board board) {
		if(board.getRoundCounter()%7==0)
			this.interference = (int) java.lang.Math.random()*6+1;
		
		return interference;
	}

	

}
