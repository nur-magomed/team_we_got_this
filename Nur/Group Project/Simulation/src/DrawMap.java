/*
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// TODO: Auto-generated Javadoc
/**
 * The Class DrawMap.
 */
public class DrawMap {
	public int [][] matrix = null;
	
	/**
	 * Draw map.
	 */
	public void DrawMap(){
	
		
		
	try {	
	
		int row=25;
		int coll=20;
		int size=0;
	

		
		FileReader file = new FileReader("files/map.txt");
		BufferedReader reader =new BufferedReader(file);
		
		
	
		
		
		String line = reader.readLine();
		String []spaces;		
		while(line != null)
		{
			spaces = line.trim().split("\\s+");
			
			
			if (matrix == null) {
	            matrix = new int[row][coll];
	        }
	
	        for (int col = 0; col <size; col++) {
	            matrix[row][col] = Integer.parseInt(spaces[col]);
	        }
	
	        row++; 
			line = reader.readLine();
		}
		
		
		
		} catch (IOException e) 
		{
	    System.err.println("Caught IOException: " + e.getMessage());
	    }

}
	
}
