import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {
	protected NoFrame frame;
	public Ghost ghost;
	protected void setUp()  throws FileNotFoundException {

		frame = new NoFrame(); 
		ghost = frame.addGhost(new Location(2, 1), "ghost1", Color.blue); 
		frame.startGame();
	}

	
	public void testGhostValidMoves() {
		Location a = new Location(1, 1);
		Location b = new Location(3, 1);
		ArrayList<Location> cords = new ArrayList<Location>();
		cords.add(a);
		cords.add(b);
		assertEquals(ghost.get_valid_moves(), cords);

	}
}