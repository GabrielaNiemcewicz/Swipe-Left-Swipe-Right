public class Node {
	private boolean isRepeatedPath;
	private Node [] children;
	private int direction;
	
	Node(){
		isRepeatedPath = false;
		initChildren();
	}
	
	Node(int dir){
		isRepeatedPath = false;
		int direction = dir;
		initChildren();
	}
	
	
	
	private void initChildren() {
		this.children = new Node [4];
	}
	
	public void initChild(int direction) {
		this.children[direction] = new Node(direction);
	}
	
	public boolean isRepeatedPath() {
		return isRepeatedPath;
	}

	public void setRepeatedPath(boolean isRepeatedPath) {
		this.isRepeatedPath = isRepeatedPath;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}	
	
}
