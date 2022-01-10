import junit.framework.*;

import javax.swing.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase {
	
	public void testMapEatCookie() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));

		Map m = frame.getMap();

		assertTrue((m.eatCookie(pacman.myName)) instanceof JComponent);
	}
}
