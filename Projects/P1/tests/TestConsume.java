import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {



		protected NoFrame frame;
		public PacMan pacman;
		public Ghost ghost;
		protected void setUp() throws FileNotFoundException {
			frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
			pacman = frame.addPacMan(new Location(1, 1));
			ghost = frame.addGhost(new Location(10, 10), "name", Color.red);
			frame.initPlayers();
			frame.startGame();
		}
	public void testConsume() throws FileNotFoundException {

		//Map currMap = frame.getMap();
		assertNotNull(pacman.consume());

	}
}
