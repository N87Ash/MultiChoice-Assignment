package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

	public class MapCreator {
		
		private String filename = "Map.txt";
		private char[][] map;
		private int mapSize = 0;
		private Scanner scanner;
		private Vector2i startPoint;
		private Vector2i endpoint;
		
		public MapCreator(String filename){
			this.filename = filename;
			this.mapSize = determineMapSize(filename);
			this.map = generateMap(filename);
		}
							
		public int determineMapSize(String filename){
			File file = new File(filename);
		
			if (file.exists()){
				try{
					FileReader fr = new FileReader(file);
					LineNumberReader lnr = new LineNumberReader(fr);
					int numLines = 0;
					while (lnr.readLine() != null){
						numLines++;
					}
					lnr.close();
					mapSize = numLines;
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
			scanner = new Scanner(filename);
				for (int row = 0; scanner.hasNextLine() && row < mapSize; row++) {
					char[] chars = scanner.nextLine().toCharArray();
					for (int i = 0; i < mapSize && i < chars.length; i++) {
						newMap[row][i] = chars[i];
					}
				}	
			return newMap;
		}
		
		
		public void showMap(){
			for(int i = 0; i<this.mapSize; i++)
				{
				    for(int j = 0; j<this.mapSize; j++)
				    {
				        System.out.print(this.map[i][j]);
				    }
				    System.out.println();
				}
		}
		
		
		public boolean isValidMap(char[][] mapToShow, int gridSize){
			int countAt = 0;
			int countX = 0;
			for(int i = 0; i<gridSize; i++)
				{
				    for(int j = 0; j<gridSize; j++)
				    {
				        if (mapToShow[i][j] == 64){
				        	countAt++;
				        }
				        if (mapToShow[i][j] == 88){
				        	countX++;
				        }
				    }			
				}
			if (countX == 1 && countAt == 1){
				return true;
			} else {
				return false;
			}
		}
		
		public Vector2i findStart(char[][] mapToShow, int gridSize){
			Vector2i vec = new Vector2i(0, 0);
			for(int i = 0; i<gridSize; i++)
				{
				    for(int j = 0; j<gridSize; j++)
				    {
				        if (mapToShow[i][j] == 64){
				        	vec.setX(i);
				        	vec.setY(j);
				        }
				       
				    }			
				}
			return vec;
		}

		public Vector2i findEnd(char[][] mapToShow, int gridSize){
			Vector2i vec = new Vector2i(0, 0);
			for(int i = 0; i<gridSize; i++)
				{
				    for(int j = 0; j<gridSize; j++)
				    {
				        if (mapToShow[i][j] == 88){
				        	vec.setX(i);
				        	vec.setY(j);
				        }
				       
				    }			
				}
			return vec;
		}

		public Vector2i getStartPoint() {
			return startPoint;
		}

		public void setStartPoint(Vector2i startPoint) {
			this.startPoint = startPoint;
		}

		public Vector2i getEndpoint() {
			return endpoint;
		}

		public void setEndpoint(Vector2i endpoint) {
			this.endpoint = endpoint;
		}
}


