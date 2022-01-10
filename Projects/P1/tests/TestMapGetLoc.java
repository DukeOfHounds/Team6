import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;

public class TestMapGetLoc extends TestCase {
	protected NoFrame frame;
	protected void setUp()  throws FileNotFoundException {
		//Creating A Map
		frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
		// //Creating Players
		PacMan pacman = frame.addPacMan(new Location(2, 3)); 

		//Start The Game
		frame.startGame();
	}

	public void testMapGetLoc() {
		Map currMap = frame.getMap();
		HashSet<Map.Type> o = currMap.getLoc(new Location(2,3));
		assertTrue(o.contains(Map.Type.PACMAN));
	
	}
}

