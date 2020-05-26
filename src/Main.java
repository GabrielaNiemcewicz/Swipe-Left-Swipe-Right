import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Board sweepPuzzle = new Board (2,3);
		String command;
		System.out.println("Write 'up', 'down', 'left', 'right' to push numbers on blank tile, your task is to sort them, 0 to 4!");
		sweepPuzzle.display();
		Scanner cin = new Scanner(System.in);
		do {
		command = cin.nextLine();
		sweepPuzzle.sweep(command);
		sweepPuzzle.display();
		}
		while (true);
	}

}
