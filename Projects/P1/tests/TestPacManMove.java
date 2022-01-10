import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;
import java.util.ArrayList;

public class TestPacManMove extends TestCase {
	protected NoFrame frame;
	public PacMan pacman;
	protected void setUp()  throws FileNotFoundException {
		//Creating A Map
		frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
		// make sure pacman's only valid move is 2,1
		Ghost ghost = frame.addGhost(new Location(1, 2), "ghost1", Color.blue);
		pacman = new PacMan("pacman", new Location(1, 1), frame.getMap());
		frame.addPacMan(new Location(1, 1));
		//Start The Game
		frame.startGame();
	}
	public void testPacManMove() throws FileNotFoundException{

		// confirm pacman location is 1,1
		assertTrue(frame.getMap().getLoc(new Location(1,1)).contains(Map.Type.PACMAN));
		ArrayList<Location> moves = pacman.get_valid_moves();
		// move pacman, only valid moves are 2,1 because ghost at 1,2
		pacman.move();
		// confirm pacman is not at 1,1 anymore
		assertTrue(!frame.getMap().getLoc(new Location(1,1)).contains(Map.Type.PACMAN));

	}
}
