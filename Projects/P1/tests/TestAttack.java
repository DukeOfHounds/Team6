import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(5, 7));
		Ghost ghost = frame.addGhost(new Location(5, 8), "Clyde", Color.red);
		assertTrue(ghost.attack());

		pacman = frame.addPacMan(new Location(8, 1));
		ghost = frame.addGhost(new Location(8, 3), "Clyde", Color.red);
		assertFalse(ghost.attack());
	}
}

