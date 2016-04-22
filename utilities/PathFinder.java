package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PathFinder {

	private Vector2i start;
	private Vector2i end;
	private char[][] map;
	private int gridSize;
	
	public PathFinder(Vector2i start, Vector2i end, char[][] map, int gridSize){
		this.setStart(start);
		this.setEnd(end);
		this.map = map;
		this.gridSize = gridSize;
	}
	
	public List<Node> findPath(Vector2i start, Vector2i end){
		//initialise
		List<Node> openList = new ArrayList<Node>();
		List<Node> closedList = new ArrayList<Node>();
		Node current = new Node(start, null, 0, getDistance(start, end));
		openList.add(current);
		//start loop
		while(openList.size()>0){
			//sort list 
			Collections.sort(openList, sorter);
			current = openList.get(0);
			if(current.getTile().isEqual(end)){
				List<Node> path = new ArrayList<Node>();
				 while (current.getParent()!=null){
					 path.add(current);
					 current = current.getParent();
				 }
				 openList.clear();
				 closedList.clear();
				 return path;
			}
			openList.remove(current);
			closedList.add(current);
			identifyChildNodes(end, openList, closedList, current);
		}
		closedList.clear();
		return null;
	}

	private void identifyChildNodes(Vector2i end, List<Node> openList,List<Node> closedList, Node current) {
		for (int i=0;i<9;i++){
			if (i==4){
				continue;
			}
			int x = current.getTile().getX();
			int y = current.getTile().getY();
			int xi = (i%3)-1;
			int yi = (i/3)-1;
			Vector2i next = new Vector2i(x+xi, y+yi);  
			//isOutofBounds
			if (isOutOfBounds(next)){
				continue;
			}
			if (!isWalkable(next)){
				continue;
			}
			double gCost = current.getgCost() + determineChoiceCost(next);
			double hCost = getDistance(next, end);
			Node childNode = new Node(next, current, gCost, hCost);
			if (isContainedInList(closedList, next)){
				continue;
			}
			if (!isContainedInList(openList, next)){
				openList.add(childNode);
			}
		}
	}		
	
	public double getDistance(Vector2i tile, Vector2i destination){
		double dx = tile.getX() - destination.getX();
		double dy = tile.getY() - destination.getY();
		return Math.sqrt((dx*dx)+(dy*dy));
	}
	
	
	private Comparator<Node> sorter = new Comparator<Node>() {
		public int compare(Node n1, Node n2){
			if(n2.getfCost() < n1.getfCost())
				return 1;
			if(n2.getfCost() > n1.getfCost())
				return -1;
			return 0;
		}
	};
	
	public boolean isOutOfBounds(Vector2i vec){
		if (vec.getX() < 0 || vec.getY() < 0 || vec.getX() >= gridSize || vec.getY() >= gridSize){
			return true;
		}
		return false;
	}
	
	public boolean isContainedInList(List<Node> list, Vector2i vec){
		for (Node n : list){
			if (n.getTile().isEqual(vec)){
				return true;
			}
		}
		return false;
	}
	
	//Check if its water~
	public boolean isWalkable(Vector2i vec){
		if (map[vec.getX()][vec.getY()] == 126){
			return false;
		}
		return true;
	}
	
	public int determineChoiceCost(Vector2i vec){
		int cost = 1;
		//Cost of forest
		if (map[vec.getX()][vec.getY()] == 42){
			cost = 2;
		}
		//Cost of Mountain
		if (map[vec.getX()][vec.getY()] == 94){
			cost = 3;
		}
		return cost;
	}

	public char[][] updateMap(List<Node> list){
		char[][] newMap = this.map;
		//Set intial point to #
		int a = this.start.getX();
		int b = this.start.getY();
		for(int i = 0; i<this.gridSize; i++)
		{
		    for(int j = 0; j<this.gridSize; j++)
		    {
		    	if (i==a && j==b){
		    		newMap[i][j] = 35;
		    	}
		    }
		}
		for (Node n : list){
			int x = n.getTile().getX();
			int y = n.getTile().getY();
			for(int i = 0; i<this.gridSize; i++)
			{
			    for(int j = 0; j<this.gridSize; j++)
			    {
			    	if (i==x && j==y){
			    		newMap[i][j] = 35;
			    	}
			    }
			}   
		}
		return newMap;
	}
	
	public void showUpdatedMap(char[][] updatedMap){
		for(int i = 0; i<this.gridSize; i++)
		{
		    for(int j = 0; j<this.gridSize; j++)
		    {
		        System.out.print(updatedMap[i][j]);
		    }
		    System.out.println();
		}
	}
	
	public Vector2i getStart() {
		return start;
	}

	public void setStart(Vector2i start) {
		this.start = start;
	}

	public Vector2i getEnd() {
		return end;
	}

	public void setEnd(Vector2i end) {
		this.end = end;
	}
}
