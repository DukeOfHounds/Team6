import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {


	public void testGhostInRange() throws FileNotFoundException{
		
	}

    protected NoFrame frame;
    public PacMan pacman;
    public Ghost g1,g2;
    protected void setUp()  throws FileNotFoundException {
        //Creating A Map
        frame = new NoFrame(); 
        pacman = frame.addPacMan(new Location(2, 2)); 
        g1 = frame.addGhost(new Location(2,3),"Biren", Color.red);
    }
    assertTrue(pacman.is_ghost_in_range());
    

}

