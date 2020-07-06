import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int n=2; int m=3; 
		Board sweepPuzzle = new Board(m,n);
		//System.out.println("current state: "+sweepPuzzle.getState()+", to destination: "+sweepPuzzle.getEND_STATE());
		RandomWalk decisionTree = new RandomWalk();
		SweepBot bot = new SweepBot();
		String command;
		System.out.println("Write 'up', 'down', 'left', 'right' to push numbers on blank tile, your task is to sort them, 0 to "+(n*m-1)+"!");
		sweepPuzzle.display();
		Scanner cin = new Scanner(System.in);
		while (!sweepPuzzle.game_over()) {
			decisionTree.repeatedPath(sweepPuzzle);
			if(!decisionTree.isIn(sweepPuzzle))
				decisionTree.recordState(sweepPuzzle);
			if(/*(sweepPuzzle.getRoundCounter()+bot.interfere_rate(sweepPuzzle))%2==0*/false)
					command = cin.nextLine();
			else {command = bot.getCommand(sweepPuzzle);
				System.out.println("Bot has intefered! "+command.toUpperCase());
			}
			sweepPuzzle.sweep(command, decisionTree);
			sweepPuzzle.display();
		} 
		cin.close();
		
		
	}

}
