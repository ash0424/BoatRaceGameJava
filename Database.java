package boatgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Database {
	private Scanner cinput;
	private Formatter coutput; 
	ArrayList <String> tempStorage = new ArrayList <String>(); 
	
	
	public void loadDatabase(Score score) {
		
		cinput = openInputFile("TopFive.txt"); 
		readTopFiveFile(score);
		closeInputFile(cinput); 
		
	}
	
	public void storeDatabase(Score score) {
		coutput = openOutputFile("TopFive.txt");
		writeTopFiveFile(score);
		closeOutputFile(coutput);
	}
	
	public Scanner openInputFile(String filename){
		Scanner tempinput=null;
		try
		{
			tempinput = new Scanner(new File(filename));
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
		return tempinput;
	}
	
	public Formatter openOutputFile(String filename) {
		Formatter tempoutput=null;
		try
		{
			tempoutput = new Formatter(new File(filename));
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
		return tempoutput;
	}
	
	public void readTopFiveFile(Score score) {

		int check = 0; 
		
		try
		{
			while (cinput.hasNext())
			{
				check = 1;
				tempStorage.add(cinput.nextLine()); 
			}


		}
		catch (NoSuchElementException elementException)
		{
			
			System.err.println("File improperly formed.");
			cinput.close();
			System.exit(1);
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		}
		
		int k = 0; 
		
		if (check == 1)
		{
			for (int i = 0; i < 5; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					score.fillTop5(i, j, tempStorage.get(k));
					k++;
				}
			}
		}
		

		
		
	}
	
	


	public void writeTopFiveFile(Score score) {
		
		
		score.printTop5();
		
		for ( int i = 0; i < 5; i++ )
		{
			for (int j = 0; j < 3; j++)
			{
				
				coutput.format("%s\n", score.getTop5(i, j));
				
			}

		}
	}
	
	public void closeInputFile(Scanner input) {
		if (input!=null)
			input.close();
	}

	public void closeOutputFile(Formatter output) {
		if (output!=null)
			output.close();
	}
}
