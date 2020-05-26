import java.util.ArrayList;
import java.util.Collections;

public class Board {

	private  int HEIGHT;
	private int WIDTH;
	private int [][] tiles;
	private int[] blank;
	//private ArrayList legalMoves;
	
	Board(int SIZE_WIDTH, int SIZE_HEIGHT)
	{
		this.HEIGHT= SIZE_WIDTH;
		this.WIDTH= SIZE_HEIGHT;
		this.blank = new int [2];
		this.blank[0]=-1;
		this.blank[1]=-1;

				tiles = new int[this.HEIGHT][this.WIDTH]; 
				this.init();	
	}
	
	public int count() {
		return HEIGHT*WIDTH;
	}
	
	private void init () {
		 
		ArrayList <Integer> range = new ArrayList<Integer>();
		for(int i =0; i<this.count();i++)
			{range.add(i);}
		Collections.shuffle(range);
		//[0][1][2]
		//[3][4][5]
		
	//	java.lang.Math.ceil(java.lang.Math.random());
		
		for(int i =0; i<HEIGHT; i++)
			for(int j =0; j<WIDTH; j++)
				{tiles[i][j] = range.get(i*WIDTH+j); 
				if(tiles[i][j]==this.count()-1)
					pivotBlank(i,j);
				}
		System.out.println(this.blank[0]+" "+this.blank[1]);
	}
	
	private void pivotBlank(int i, int j) {
		this.blank[0] = i;
		this.blank[1] = j;
	}
	
	
	public void display(){
		for(int i =0; i<HEIGHT; i++) {
			for(int j =0; j<WIDTH; j++) {
				if(tiles[i][j]==this.count()-1)
					System.out.print("[_]");
				else
					System.out.print("["+tiles[i][j]+"]");}
			System.out.println(" ");	}
		}
	
	public void swap (int sourceHe, int sourceWi, int destinHe, int destinWi) {
	int tempWid, tempHei, tempTile;
	tempWid = destinHe;
	tempHei = destinWi;
	tempTile = tiles[tempWid][tempHei];

	tiles[destinHe][destinWi] = tiles[sourceHe][sourceWi];
	tiles[sourceHe][sourceWi] = tempTile;

	this.pivotBlank(sourceHe, sourceWi);
	}
	
	public boolean[] getLegalMoves() {
		boolean [] isLegal = new boolean[4]; //is each of the moves legal?
		//0: down 1: up 2: right 3: left
		for(int i =0;i<4;i++)
			isLegal[i] = true;
		
		if(blank[0]==0)
			isLegal[1] = false;
		if(blank[1]==0)
			isLegal[2] = false;
		if(blank[0]==HEIGHT-1)
			isLegal[0] = false;
		if(blank[1]==WIDTH-1)
			isLegal[3] = false;
		
		return isLegal;
	}
	
	//precondition: sweep is legal
	public void sweep (String direction)
	{
		boolean [] isLegal = this.getLegalMoves();
		
		int destinHei = blank[0];
		int destinWi = blank[1];
		 
		
		switch(direction) {
			case "up":
				if(isLegal[0])
				swap(destinHei+1,destinWi,destinHei,destinWi);
				break;
			case "down":
				if(isLegal[1])
				swap(destinHei-1,destinWi,destinHei,destinWi);
				break;
			case "right":
				if(isLegal[2])
				swap(destinHei,destinWi-1,destinHei,destinWi);
				break;
			case "left":
				if(isLegal[3])
				swap(destinHei,destinWi+1,destinHei,destinWi);
				break;
			default:
				System.out.println("Sweeping direction incorrect:"+direction);
		}
	
	}
	}
	
