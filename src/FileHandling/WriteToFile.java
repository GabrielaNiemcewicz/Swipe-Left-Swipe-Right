package FileHandling;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
public static void main (String [] args) {
	try {
		FileWriter fin = new FileWriter("RandomWalk.txt");
		fin.write("Hashes recorded:");
		fin.close();
		fin.append("Current run:");
		
	} catch(IOException e)
	{
		e.printStackTrace();
		
	}
	
	
	
	
}
}
