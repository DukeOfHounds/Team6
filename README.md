# CMSC388T Team 6 Project  - Pacman

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
![Image of PacMan](https://i.imgur.com/dlSCJVL.png)

## List of Functions


### PacMan Class

#### get_valid_moves()

- Type: () –> ArrayList
- Author: Nathan Laieke
- Implementation Description: Given Pacman’s current position, the function will return all possible moves it can make (i.e. all open spaces that aren’t occupied by ghosts). Accomplished by initializing an ArrayList of type Location. Then, use the myLoc fields to see if the spots above, below, left, and right of the Pacman don’t contain a wall or a ghost. If those locations don’t contain either a ghost or a wall, we will add the location of the spot to the ArrayList.
- Test Description: Initialized a NoFrame with a PacMan character at location (2,1). The only possible moves for PacMan at that location would be (1,1) and (3,1) according to Map.txt (which is utilized by NoFrame.java to make the map). Finally, Initialize an ArrayList and add those locations to it and then assert that get_valid_moves() will return an ArrayList that is equal to the ArrayList we created.

#### move()

- Type: () –> Boolean
- Author: Luke Perry
- Implementation Description: First we call get_valid_moves() to see where pacman can move, and return false if there are no moves, next we compute a random index from 0 to length of moves and move to that location.
- Test Description: To test this feature, we declare pacman at a location and move pacman, then assert that pacman is not in the previous location

#### is_ghost_in_range()

- Type: () –> Boolean
- Author: Nathaniel Bekele
- Implementation Description: 
- We check if the ghost is in attack range, i.e in 1 “block” and return true if it is.
- Test Description: Initialize a map, a pacman and a ghost, the pacman and the ghosts are in attack range,. Then assert that the function returns true when run. 

#### consume()

- Type: () –> JComponent
- Author: Amir Mirgeloybayat
- Implementation Description: This method checks to see if there is a Cookie Component at PacMan’s the current (x, y) location and helps with the consumption of the cookie. The actual act of consumption is done via the eatCookie method in Map class. Therefore, in the case of Cookie Component co-existing with PacMan at the same location, we call and return the result of cookieConsumption from Map; otherwise, we return null.
- Test Description: To test this method, a board was initiated via the NoFrame class and then, a PacMan was initiated at on a house with a Cookie Component. We asserted that the result of calling the method was not null.






### Ghost Class

#### get_valid_moves()

- Type: () –> ArrayList<Location>
- Author: Nathan Laieke
- Implementation Description: Given a ghost’s current position, the function will return all possible moves it can make (i.e. all open spaces/ no walls). Accomplished by initializing an ArrayList of type Location. Then, use the myLoc fields to see if the spots above, below, left, and right of the ghosts don’t contain a wall. If those locations don’t contain either a ghost or a wall, we will add the location of the spot to the ArrayList.
- Test Descripion: Initialized a NoFrame with a ghost character at location (2,1). The only possible moves for the ghost at that location would be (1,1) and (3,1) according to Map.txt (which is utilized by NoFrame.java to make the map). Finally, Initialize an ArrayList and add those locations to it and then assert that get_valid_moves() will return an ArrayList that is equal to the ArrayList we created.

#### move()

- Type: () -> Bool
- Author: Luke Perry
- Implementation Description: First we call get_valid_moves() to see where the ghost can move, and return false if there are no moves, next we compute a random index from 0 to length of moves and move to that location.
- Test Descripion: To test this feature, we declare the ghost at a location and move the ghost, then assert that pacman is not in the previous location



#### is_pacman_in_range()

- Type: () –> Boolean
- Author: Nathaniel Bekele
- Implementation Description: We check if the pacman is in attack range, i.e in 1 “block” and return true if it is.
- Test Description: Initialize a map, a pacman and 2 ghosts, the pacman and one of the ghosts are in attack range, the other ghost is not. Then assert that the function returns true if the ghost is in range and false for the other ghost. 

#### attack()

- Type: () –> Boolean
- Author: Amir Mirgeloybayat
- Implementation Description: This method checks to see if the PacMan is within reach of a Ghost player. In that case, the ghost attacks PacMan. The actual attack functionality is resolved via the attack function from the Map class. Therefore, this function returns the result of the Map attack() in case of PacMan being within reach and false otherwise.
- Test Description: Initiated a game via the NoFrame functionality, and initiated two ghosts and a pacman; one ghost can reach the pacman location-wise and one can’t. Then, we check to see if the one that can’t reach correctly return false, and the one that can, returns true.



### Map Class

#### move(String name, Location loc, Type type)

- Type: (String name, Location loc, Type type) –> Boolean
- Author: Luke Perry
- Implementation Description: Move is implemented by first getting the old location and confirming it is not a wall or null, then adding it to locations. Next, we update the jcomponent, and finally we update fields by placing the object in the new location and removing it from the old location.
- Test Description: To test move is implemented correctly, we first instantiate pacman at a location. Next we assert pacman is at the original location, then we move pacman to another location, assert pacman is at the new location, and assert pacman is not at the old location. 

#### getLoc()

- Type: (Location loc) -> HashSet<Type>
- Author: Nathan Laieke
- Implementation Description: For the given location argument, the function will return the Types at the current location. This is done by utilizing field.get(), which should return the types at the location passed in. However, if field.get() returns null, then we can assume for there to be a wall at that space and return the wallSet field.
- Test Description: First, we instantiate a NoFrame with a Pacman object at location (2,3). We then assert that getLoc() returns a HashSet that contains a Pacman type.

#### attack(String name)

- Type: (String name) -> Boolean
- Author: Nathaniel Bekele
- Implementation Description: We take the absolute value in the difference between the ghost’s x and y coordinates with that of the pacman’s and return true if the absolute difference is less than or equal to 1 and if not we return false.
- Test Description: Initialize a map, a pacman and a ghost, the pacman and the ghost are in attack range then assert that it returns true if the ghost was to attack the pacman.

#### eatCookie():

- Type: () -> JComponent
- Author: Amir Mirgeloybayat
- Implementation Description: This method is responsible for consuming the cookie component that co-exists on a house with the pacman. Consuming the cookie basically means that:
The cookie needs to get removed from the field
The cookie needs to get removed from the components field
The cookie needs to get removed from the locations field
These fields are all hashmap with their keys being the cookie’s id
To make the cookie id, we have to say: 
"tok_x" + cookieLoc.x + "_y" + cookieLoc.y
The method tries to get the cookie by its location, and the in tries to remove the cookie component from the HashSet of components that sit on the that specific location. After that, it creates the ID based on the location and proceeds to remove the cookie from the fields. Finally, it will return the Cookie Component
- Test Description: To test this method, we created a game via the NoFrame functionality, and then we initiated the PacMan on a Cookie location and then, checked to see if calling the consume will not return Null. By that, we are sure that the function is called properly.
