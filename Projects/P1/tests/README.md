# CMSC388T Team 6 Project 1 - Pacman

## Names
Luke Perry, Nathan Laieke, Amir Mirgeloybayat, Nathaniel Bekele


## How to run code
To play Pacman, run these commands from the root P1/ directory:

```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

To run any of the JUnit tests, run these commands from the root P1/ directory:

```bash
javac -cp "tests/junit-4.10.jar:src/:tests/" src/*.java tests/*.java
java -cp "tests/junit-4.10.jar:src/:tests/" org.junit.runner.JUnitCore your_test_here
ex: java -cp "tests/junit-4.10.jar:src/:tests/" org.junit.runner.JUnitCore TestGhostMove
```

## Image of Pacman running

## List of Functions


### PacMan Class

#### get_valid_moves()

- Type: () –> ArrayList
- Author: Nathan Laieke
- Implementation Description: Given Pacman’s current position, the function will return all possible moves it can make (i.e. all open spaces that aren’t occupied by ghosts). Accomplished by initializing an ArrayList of type Location. Then, use the myLoc fields to see if the spots above, below, left, and right of the Pacman don’t contain a wall or a ghost. If those locations don’t contain either a ghost or a wall, we will add the location of the spot to the ArrayList.
- Test Description: Initialized a NoFrame with a PacMan character at location (2,1). The only possible moves for PacMan at that location would be (1,1) and (3,1) according to Map.txt (which is utilized by NoFrame.java to make the map). Finally, Initialize an ArrayList and add those locations to it and then assert that get_valid_moves() will return an ArrayList that is equal to the ArrayList we created.






### Ghost Class

#### get_valid_moves()

- Type: () –> ArrayList<Location>
- Author: Nathan Laieke
- Implementation Description: Given a ghost’s current position, the function will return all possible moves it can make (i.e. all open spaces/ no walls). Accomplished by initializing an ArrayList of type Location. Then, use the myLoc fields to see if the spots above, below, left, and right of the ghosts don’t contain a wall. If those locations don’t contain either a ghost or a wall, we will add the location of the spot to the ArrayList.
- Test Descripion: Initialized a NoFrame with a ghost character at location (2,1). The only possible moves for the ghost at that location would be (1,1) and (3,1) according to Map.txt (which is utilized by NoFrame.java to make the map). Finally, Initialize an ArrayList and add those locations to it and then assert that get_valid_moves() will return an ArrayList that is equal to the ArrayList we created.




### Map Class

#### getLoc()

- Type: (Location loc) -> HashSet<Type>
- Author: Nathan Laieke
- Implementation Description: For the given location argument, the function will return the Types at the current location. This is done by utilizing field.get(), which should return the types at the location passed in. However, if field.get() returns null, then we can assume for there to be a wall at that space and return the wallSet field.
- Test Description: First, we instantiate a NoFrame with a Pacman object at location (2,3). We then assert that getLoc() returns a HashSet that contains a Pacman type.