package FileHandling;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFromFile {

	public static void main(String[] args)  {
		try {
		File file = new File("RandomWalk.txt");
		Scanner fin = new Scanner(file);
		while (fin.hasNextLine()) {
			String line = fin.nextLine();
			System.out.println(line);}
		fin.close();
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
