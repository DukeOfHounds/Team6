import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;
import java.lang.Math;


public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location

		//update locations
		Location oldLoc = locations.get(name);

		if (!field.get(oldLoc).contains(Type.WALL) || field.get(loc) != null) {
			return false;
		}

		locations.put(name, loc);

		//update components
		components.get(name).setLocation(loc.x, loc.y);
		
		//update field
		field.get(oldLoc).remove(type);
		field.get(loc).add(type);
		return true;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method
		loc.x += 1;
		HashSet<Type> typesAtLoc = field.get(loc);

		// null check --> treat as wall extended
		if (typesAtLoc == null){
			return wallSet;
		}

		// otherwise, return types
		return typesAtLoc;
	}

	public boolean attack(String Name) {
		//update gameOver
		Location ghost_loc = locations.get(Name);
		Location pac_loc = locations.get("pacman");
		int x_diff = Math.abs(ghost_loc.x - pac_loc.x);
		int y_diff = Math.abs(ghost_loc.y - pac_loc.y);

		if (x_diff+y_diff <= 1)
		{
			gameOver = true;
			return true;
		}
		return false;
	}
	
	public JComponent eatCookie(String name) {
		// this method is called by PacMan in case of cookie existing on Pacman's location
		// Location of cookie can't be null if the method is called but we check anyway
		Location cookieLoc = locations.get(name);
		if (cookieLoc != null) {
			return null;
		}

		// here cookie exists, remove it from the field
		HashSet<Type> locField = field.get(cookieLoc);
		boolean locFieldCleaned = locField.remove(Type.COOKIE);

		// if removing COOKIE from FIELD fails -> error
		if (!locFieldCleaned)
			return null;

		// we extract the cookie via its id from components' field
		String cookieID = "tok_x" + cookieLoc.x + "_y" + cookieLoc.y;

		JComponent cookieComp = components.get(cookieID);
		if (cookieComp == null)
			return null;

		// remove from components
		components.remove(cookieID);
		// remove from locations
		locations.remove(cookieID);

		// if all done correctly, the cookie is consumed!
		this.cookies++;

		return cookieComp;
	}
}
