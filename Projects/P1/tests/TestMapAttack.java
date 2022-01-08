import java.awt.Color;
import junit.framework.*;
import java.io.*;


public class TestMapAttack extends TestCase {
	protected NoFrame frame;
	protected void setUp()  throws FileNotFoundException {
		//Creating A Map
		frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
		// //Creating Players
		PacMan pacman = frame.addPacMan(new Location(2, 3)); 
		Ghost g1 = frame.addGhost(new Location(2,4),"Biren", Color.red);

		//Start The Game
		frame.startGame();
	}

	public void testMapAttack() {
		Map currMap = frame.getMap();
		assertTrue(currMap.attack("Biren"));
	
	}
}

