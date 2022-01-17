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
		ArrayList<Location> possible_moves = new ArrayList<Location>();
		
		// check possible up move
		if (!myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.WALL) && !myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.GHOST)){
			possible_moves.add(new Location(myLoc.x, myLoc.y + 1));
		}

		// Check possible down move
		if (!myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)).contains(Map.Type.WALL) && !myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)).contains(Map.Type.GHOST)){
			possible_moves.add(new Location(myLoc.x, myLoc.y - 1));
		}

		// Check possible left move
		if (!myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)).contains(Map.Type.WALL) && !myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)).contains(Map.Type.GHOST)){
			possible_moves.add(new Location(myLoc.x - 1, myLoc.y));
		}

		// Check possible right move
		if (!myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.WALL) && !myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.GHOST)){
			possible_moves.add(new Location(myLoc.x + 1, myLoc.y));
		}

		return possible_moves;
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
		if (moves.isEmpty()) {
			return false;
		}

		// get random move
		Random rand = new Random();
		int randomIndex = rand.nextInt(moves.size());
		Location move = moves.get(randomIndex);

		// complete move
		this.myLoc = move;
		this.myMap.move(myName, move, Map.Type.PACMAN);
		return true;
	}

	public boolean is_ghost_in_range() 
	{ 
		if (myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.GHOST)||
		myMap.getLoc(new Location(myLoc.x+1, myLoc.y)).contains(Map.Type.GHOST)||
		myMap.getLoc(new Location(myLoc.x, myLoc.y-1)).contains(Map.Type.GHOST)||
		myMap.getLoc(new Location(myLoc.x-1, myLoc.y)).contains(Map.Type.GHOST))
		{
			return true;
		}
		return false;
	}

	public JComponent consume() {
		
		HashSet<Map.Type> pacmanCurrLoc = myMap.getLoc(myLoc);

		if (pacmanCurrLoc.contains(Map.Type.COOKIE)) {
			return myMap.eatCookie(myName);
		}
		return null;
	}

}
