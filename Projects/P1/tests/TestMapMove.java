import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;

public class TestMapMove extends TestCase {
	protected NoFrame frame;
	protected void setUp()  throws FileNotFoundException {
		//Creating A Map
		frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
		// //Creating Players
		PacMan pacman = frame.addPacMan(new Location(1, 1)); 

		//Start The Game
		frame.startGame();
	}

	public void testMapMove() {

		// Get Map
		Map currMap = frame.getMap();
		// check pacman at 1,1
		HashSet<Map.Type> setOneOne = currMap.getLoc(new Location(1,1));
		assertTrue(setOneOne.contains(Map.Type.PACMAN));
		// move pacman to 1,2
		currMap.move("pacman", new Location(1,2), Map.Type.PACMAN);
		// check pacman is at 1,2
		HashSet<Map.Type> setOneTwo = currMap.getLoc(new Location(1,2));
		assertTrue(setOneTwo.contains(Map.Type.PACMAN));
		// check pacman not at 1,1 still
		setOneOne = currMap.getLoc(new Location(1,1));
		assertTrue(!setOneOne.contains(Map.Type.PACMAN));
		// try moving pacmac to 0,0 but there is wall
		assertTrue(!currMap.move("pacman", new Location(0,0), Map.Type.PACMAN));

		

	}
}
