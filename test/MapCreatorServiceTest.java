package test;

import org.junit.Assert;
import org.junit.Test;

import utilities.MapCreator;
import utilities.Vector2i;

public class MapCreatorServiceTest {

	@Test
	public void createMapObject() {
		//Map.txt is a 50 by 50 character text file
		String filename = "Map.txt";
		MapCreator map = new MapCreator(filename);
		Assert.assertTrue(map.getMapSize() == 50);
		Assert.assertTrue(map.isValidMap() == true);
		Vector2i start = new Vector2i(0, 0);
		Assert.assertTrue(map.findStart().isEqual(start));
		Vector2i end = new Vector2i(49,49);
		Assert.assertTrue(map.findEnd().isEqual(end));
	}

}
