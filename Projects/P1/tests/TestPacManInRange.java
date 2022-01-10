import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {
	protected NoFrame frame;
	public PacMan pacman;
	public Ghost g1,g2;
	protected void setUp()  throws FileNotFoundException {
		//Creating A Map
		frame = new NoFrame(); 
		pacman = frame.addPacMan(new Location(2, 2)); 
		g1 = frame.addGhost(new Location(2,3),"Biren", Color.red);
		g2 = frame.addGhost(new Location(2,5),"Nati", Color.blue);
		

		frame.startGame();
	}

	public void testPacManInRange()
	{
		assertTrue(g1.is_pacman_in_range());
		assertFalse(g2.is_pacman_in_range());

	}
}
