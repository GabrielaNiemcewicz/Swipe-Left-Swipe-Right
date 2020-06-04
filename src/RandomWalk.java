import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class RandomWalk {
	private TreeSet<String> visitedPaths;
	//Node commandsMemory = new Node();
	TreeSet<Node> commandMemory;
	Stack<String> userCommands; //simplification for this release
	ArrayList<String>userCommand;
	
	public RandomWalk() {
	visitedPaths = new TreeSet<String>();
	commandMemory = new TreeSet<Node>();
	userCommands = new Stack<String>();
//	userCommand = new ArrayList<String>();
	}
	
	
	
	public void recordMove(String direction, boolean isValid) {
		if(isValid) 
		userCommands.add(direction);
		}

	
	public String undoMove() {
		//Node command = commandMemory.pollFirst();
		if(this.size_moves()==0)
			return "";
		String command= userCommands.pop();

		
		switch(command) {
		case "down":
			return "up";
			
		case "up":
			return "down";
			
		case "left":
			return "right";
			
		case "right":
			return "left";
			
		default:
			return "";
		}
		
	}
	
	public int size_moves()
	{	return userCommands.size();	}
	
	public void peek()
	{	for(int i=0;i<userCommands.size();i++) 
		System.out.print(userCommands.get(i)+"  ");	}
	
	
	public void recordState(Board sweepBoard) 
	{	visitedPaths.add(sweepBoard.getState());	}
	
	public boolean isIn(Board sweepBoard)
	{	return visitedPaths.contains(sweepBoard.getState())?true:false;		}
	
	public void repeatedPath(Board sweepBoard) {
		if(isIn(sweepBoard))
			System.out.println("You came back to recorded configuration");
	}

}