package FileHandling;
import java.io.File;
import java.io.IOException;

import java.io.File;

public class CreateFile {
public static void main(String[]args) {
	try {
		File file = new File("Random Walk.txt");
		if(file.createNewFile())
			System.out.println("New file created");
		else 
			System.out.println("File exists");
	//~~~
		if(file.exists())
		file.getName();
		file.getAbsolutePath();
		file.canWrite();//or read
		file.length();
	
	
	}
	catch(IOException e) {
		System.out.println("IOstream expcetion");
		e.printStackTrace();
		//~~~~
	
		
		
	}
	
	
	
	
	
}
}
