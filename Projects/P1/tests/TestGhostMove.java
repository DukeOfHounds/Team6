import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {
	protected NoFrame frame;
	protected void setUp()  throws FileNotFoundException {
		//Creating A Map
		frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
		//Creating Players
		Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); 
		PacMan pacman = frame.addPacMan(new Location(0, 0)); 

		//Start The Game
		frame.startGame();
	}

	public void testGhostMove() throws FileNotFoundException{
		//Creating A Map
		// Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		// NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
		assertTrue("hello world".equals("hello world"));
		// assertTrue(fValue1 == 2.0);
		// assertTrue("hello world".equals("hello world"));	
		// assertTrue("hello world".equals("hello orld"));	
	}
}
