/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac Game.java
 *  
 *  Implements the interface Game class.
 *
 ******************************************************************************/

public abstract class Game {

	private String id;
	private String casinoID;
	// Figure out the probability table --> private probTable;

	public String name;
	public double costToBuild;
	public int seatsAvailable;
	public int seatsOccupied;

	Game(String id, String casinoID, String name) {
		this.id = id;
		this.casinoID = casinoID;
		this.name = name;
	}

	public String getID() {
		return id;
	}

	public void playGame(String playerID, double bet) {
		System.out.print("It looks like playGame was not implemented correctly.")
	}
}