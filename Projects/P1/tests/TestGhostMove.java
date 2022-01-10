import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostMove extends TestCase {
	protected NoFrame frame;
	public Ghost ghost;
	protected void setUp()  throws FileNotFoundException {
		//Creating A Map
		frame = new NoFrame(); 
		// make sure ghost's only valid move is ??,??
		ghost = new Ghost("ghost", new Location(1, 1), frame.getMap());
		frame.addGhost(new Location(1, 1), "ghost", Color.blue);
		//Start The Game
		frame.startGame();
	}

	public void testGhostMove() throws FileNotFoundException{
		// confirm ghost location is 1,1
		assertTrue(frame.getMap().getLoc(new Location(1,1)).contains(Map.Type.GHOST));
		// move ghost, only valid moves are 2,1 or 1,2 because of walls
		ghost.move();
		// confirm ghost is not at 1,1 anymore
		assertTrue(!frame.getMap().getLoc(new Location(1,1)).contains(Map.Type.PACMAN));
	}
}
