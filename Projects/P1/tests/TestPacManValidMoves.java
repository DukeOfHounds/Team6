import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {
	protected NoFrame frame;
	public PacMan pacman;
	protected void setUp()  throws FileNotFoundException {
		
		frame = new NoFrame(); 
		pacman = frame.addPacMan(new Location(2, 1)); 
		frame.startGame();
	}




	public void testPacManValidMoves() {
		Location a = new Location(1, 1);
		Location b = new Location(3, 1);
		ArrayList<Location> cords = new ArrayList<Location>();
		cords.add(a);
		cords.add(b);
		assertEquals(pacman.get_valid_moves(), cords);

	}
}
