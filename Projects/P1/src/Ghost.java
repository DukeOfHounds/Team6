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
		if (!myMap.getLoc(new Location(myLoc.x + 1, myLoc.y)).contains(Map.Type.COOKIE)){
			possible_moves.add(new Location(myLoc.x + 1, myLoc.y));
		}
		
		
		return possible_moves;


	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
		if (moves.isEmpty()) {
			return false;
		}
		Random rand = new Random();
		Location move = moves.get(rand.nextInt(moves.size())+10);
		this.myLoc = move;
		myMap.move(myName, move, Map.Type.GHOST);
		return true;
	}

	public boolean is_pacman_in_range() { 
		if (myMap.getLoc(new Location(myLoc.x, myLoc.y + 2)).contains(Map.Type.PACMAN)||
        myMap.getLoc(new Location(myLoc.x+2, myLoc.y)).contains(Map.Type.PACMAN)||
        myMap.getLoc(new Location(myLoc.x, myLoc.y-2)).contains(Map.Type.PACMAN)||
        myMap.getLoc(new Location(myLoc.x-2, myLoc.y)).contains(Map.Type.GHOST))
        {
            return true;
        }
        return false;

	}

	public boolean attack() {
		if (is_pacman_in_range())
			return myMap.attack(myName);
		else
			return false;
	}
}
