package test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import utilities.MapCreator;
import utilities.Node;
import utilities.PathFinder;
import utilities.Vector2i;

public class PathFinderServiceTest {

	@Test
	public void testPathFinderAlgorithm() {
		
		//Test impossible map
		String filename2 = "MapWithNoPossibleRoute.txt";
		MapCreator map2 = new MapCreator(filename2);
		PathFinder path2 = new PathFinder(map2.findStart(), map2.findEnd(), map2.getMap(), map2.getMapSize());
		List<Node> test = path2.findPath(map2.findStart(), map2.findEnd());
		
		System.out.println();
		
		//Test each function with 
		String filename = "Map.txt";
		MapCreator map = new MapCreator(filename);
		PathFinder path = new PathFinder(map.findStart(), map.findEnd(), map.getMap(), map.getMapSize());
		//Test out of bounds
		Assert.assertFalse(path.isOutOfBounds(new Vector2i(49, 49)));
		Assert.assertTrue(path.isOutOfBounds(new Vector2i(50, 50)));
		//Test walkable
		Assert.assertTrue(path.isWalkable(new Vector2i(0, 0)));
		Assert.assertFalse(path.isWalkable(new Vector2i(10, 10)));
		//getDistance
		Assert.assertTrue(path.getDistance(new Vector2i(0, 0), new Vector2i(10, 10)) == 14.142135623730951);
		
		//Test the isContainedInList method
		List<Node> testList = new ArrayList<Node>();
		Node testNode = new Node(new Vector2i(10, 10), null, 5, 15);
		testList.add(testNode);
		Assert.assertFalse(path.isContainedInList(testList, new Vector2i(1,2)));
		Assert.assertTrue(path.isContainedInList(testList, new Vector2i(10,10)));
		
		//Retrieve path, update map and display
		testList = path.findPath(map.findStart(), map.findEnd());
		char[][] newMap = path.updateMap(testList);
		path.showUpdatedMap(newMap);
		
		
		
		
	}

}
