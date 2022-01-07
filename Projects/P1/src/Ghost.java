import java.util.HashSet;
import java.util.ArrayList;

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
		ArrayList<Location> possible_moves = new ArrayList<Location>();

		if (!myMap.getLoc(new Location(myLoc.x, myLoc.y + 1)).contains(Map.Type.WALL)){
			possible_moves.add(new Location(myLoc.x, myLoc.y + 1));
		}

		// Check possible down move
		if (!myMap.getLoc(new Location(myLoc.x, myLoc.y - 1)).contains(Map.Type.WALL)){
			possible_moves.add(new Location(myLoc.x, myLoc.y - 1));
		}

		// Check possible left move
		if (!myMap.getLoc(new Location(myLoc.x - 1, myLoc.y)).contains(Map.Type.WALL)){
			possible_moves.add(new Location(myLoc.x - 1, myLoc.y));
		}

		// Check possible right move
		if (!myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.WALL)){
			possible_moves.add(new Location(myLoc.x + 1, myLoc.y));
		}
		
		
		return possible_moves;


	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
