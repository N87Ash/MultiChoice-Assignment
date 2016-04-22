package test;

import org.junit.Assert;
import org.junit.Test;

import utilities.MapCreator;
import utilities.Vector2i;

public class MapCreatorServiceTest {

	@Test
	public void createMapObject() {
		
		//Test an invalid file
		String filename = "BrokenMap.txt";
		MapCreator map = new MapCreator(filename);
		//Check the map size 
		Assert.assertTrue(map.getMapSize() == 50);
		//I defined valid as having only one @ and only one X
		Assert.assertTrue(map.isValidMap() == false);
		Assert.assertTrue(map.findStart() == null);
		Assert.assertTrue(map.findEnd() == null);
		
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		//Map.txt is a 50 by 50 character text file
		filename = "Map.txt";
		map = new MapCreator(filename);
		map.showMap();
		//Check the map size 
		Assert.assertTrue(map.getMapSize() == 50);
		//I defined valid as having only one @ and only one X
		Assert.assertTrue(map.isValidMap() == true);
		Vector2i start = new Vector2i(0, 0);
		//Find start and end point on map
		Assert.assertTrue(map.findStart().isEqual(start));
		Vector2i end = new Vector2i(49,49);
		Assert.assertTrue(map.findEnd().isEqual(end));
		//Map is all set and ready for algorithm
	}

}
