package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapCreator {
	
	static String filename = "Map.txt";
	public char[][] myArray;
	private Scanner scanner;
	
	public MapCreator(String filename){
		
		int totalRow = 50;
		int totalColumn = 50;
		char[][] myArray = new char[totalRow][totalColumn];
		File file = new File(filename);
		try {
			scanner = new Scanner(file);
			for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
			    char[] chars = scanner.nextLine().toCharArray();
			    for (int i = 0; i < totalColumn && i < chars.length; i++) {
			        myArray[row][i] = chars[i];
			    }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String args[]){
		
		int totalRow = 50;
		int totalColumn = 50;
		char[][] myArray = new char[totalRow][totalColumn];
		File file = new File(filename);
		try {
			Scanner scanner = new Scanner(file);
			for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
			    char[] chars = scanner.nextLine().toCharArray();
			    for (int i = 0; i < totalColumn && i < chars.length; i++) {
			        myArray[row][i] = chars[i];
			    }
			}
			
			for(int i = 0; i<totalRow; i++)
			{
			    for(int j = 0; j<totalColumn; j++)
			    {
			        System.out.print(myArray[i][j]);
			    }
			    System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 

}
