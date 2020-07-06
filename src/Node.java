public class Node {
	private boolean isRepeatedPath;
	private Node [] children;
	private int direction;
	
	Node(){
		this.isRepeatedPath = false;
		this.children = new Node[4];
	}
	
	Node(int dir){
		isRepeatedPath = false;
		int direction = dir;
	    this.children = new Node[4]; 
	}
	
	
	
	private void initChildren() {
		for(int i=0;i<4;i++)
			this.children[i] = new Node(i);
	//	this.children = new Node [4];
	}
	
	public void initChild(int direction) {
		this.children[direction] = new Node(direction);
	}
	
	public boolean isRepeatedPath() {
		return isRepeatedPath;
	}

	public void setRepeatedPath() {
		this.isRepeatedPath = true;
	}
	public void autosetRepeatedPath() 
	{		this.isRepeatedPath = isParentRedundant();	}
	
	private boolean isParentRedundant() {
		for(Node child: children)
			if (!child.isRepeatedPath())
				return false;
		return true;
	}
	

	public Node[] getChildren() {
		return children;
	}

	public void setChildren() {
		Node[] children = new Node[4];
		for(Node child:children)
			
		this.children = children;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}	
	
	
	public boolean setLegalPaths(Board board, RandomWalk memory) {
		boolean [] legalPaths = new boolean [4];
		legalPaths = board.getLegalMoves();
			if(memory.isIn(board))
				{this.setRepeatedPath();
				return false;
				}
			//undo move, until at non-repeated node 
			for (int i=0;i<this.getChildren().length;i++)
				if(legalPaths[i]==false)
					this.getChildren()[i].setRepeatedPath();
		return true;
	}
	
	public static void main(String[] args) {
		
		Node start = new Node();
		start.initChildren();
		start.getChildren()[0].initChild(2);
		for(Node child:start.getChildren())
			child.setRepeatedPath();
		start.autosetRepeatedPath();
			
		
		if(start.isRepeatedPath())
			System.out.println("passed");
		else
			System.out.println("failed");
		
		
		
		
		
		
		
	}
	
}
