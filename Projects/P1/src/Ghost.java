import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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
		Random rand = new Random();
		Location move = moves.get(rand.nextInt(moves.size()));
		this.myLoc = move;
		myMap.move(myName, move, Map.Type.GHOST);
		return true;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
