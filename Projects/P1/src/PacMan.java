import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

public class PacMan{

	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;	
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
		if (moves.isEmpty()) {
			return false;
		}

		// get random move
		Random rand = new Random();
		Location move = moves.get(rand.nextInt(moves.size()));

		// complete move
		this.myLoc = move;
		this.myMap.move(myName, move, Map.Type.PACMAN);
		return true;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
