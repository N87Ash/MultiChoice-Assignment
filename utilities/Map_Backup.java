package utilities;



	import java.io.BufferedInputStream;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.LineNumberReader;
	import java.util.Scanner;

	public class Map_Backup {
		
		private String filename = "Map.txt";
		private char[][] map;
		private Scanner scanner;
		private int mapSize = 0;
		
		public Map_Backup(String filename){
			this.filename = filename;
			this.mapSize = determineMapSize(filename);
			this.map = generateMap(filename);
		}
			
			//int totalRow = 50;
			//int totalColumn = 50;
			//char[][] myArray = new char[totalRow][totalColumn];
			//File file = new File(filename);
			//if (file.exists() && file.isDirectory()){
			//	try {
					
//					FileReader fr = new FileReader(file);
//					LineNumberReader lnr = new LineNumberReader(fr);
//					int numLines = 0;
//					while (lnr.readLine() != null){
//						numLines++;
//					}
//					lnr.close();
					
					
//					map = new char[mapSize][mapSize];
//					
//					
//					scanner = new Scanner(file);
//					for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
//						char[] chars = scanner.nextLine().toCharArray();
//						for (int i = 0; i < totalColumn && i < chars.length; i++) {
//							map[row][i] = chars[i];
//						}
//					}
//				} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} else {
//				System.out.println("File does not exist");
//			}
//		}
		
		public int determineMapSize(String filename){
			File file = new File(filename);
		
			if (file.exists() && file.isDirectory()){
				try{
					FileReader fr = new FileReader(file);
					LineNumberReader lnr = new LineNumberReader(fr);
					int numLines = 0;
					while (lnr.readLine() != null){
						numLines++;
					}
					lnr.close();
				} catch(IOException e){
					e.printStackTrace();
				}	
			} else {
				System.out.println("File does not exist");
			}
			return mapSize;
		}
		
		
		public char[][] generateMap(String filename){
			char[][] newMap = new char[mapSize][mapSize];		
			Scanner scanner = new Scanner(filename);
				for (int row = 0; scanner.hasNextLine() && row < mapSize; row++) {
					char[] chars = scanner.nextLine().toCharArray();
					for (int i = 0; i < mapSize && i < chars.length; i++) {
						newMap[row][i] = chars[i];
					}
				}	
			return newMap;
		}
		
		
		
		
//		public static void main(String args[]){
//			
//			int totalRow = 50;
//			int totalColumn = 50;
//			char[][] myArray = new char[totalRow][totalColumn];
//			File file = new File(filename);
//			try {
//				Scanner scanner = new Scanner(file);
//				for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
//				    char[] chars = scanner.nextLine().toCharArray();
//				    for (int i = 0; i < totalColumn && i < chars.length; i++) {
//				        myArray[row][i] = chars[i];
//				    }
//				}
//				
//				for(int i = 0; i<totalRow; i++)
//				{
//				    for(int j = 0; j<totalColumn; j++)
//				    {
//				        System.out.print(myArray[i][j]);
//				    }
//				    System.out.println();
//				}
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	//
//		} 

	}


