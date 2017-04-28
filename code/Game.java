/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
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

	Game(){};
	
	Game(String id, String casinoID, String name) {
		this.id = id;
		this.setCasinoID(casinoID);
		this.name = name;
	}

	public String getID() {
		return id;
	}

	public void playGame(String playerID, double bet) {
		System.out.print("It looks like playGame was not implemented correctly, in Game.");
	}

	public String getCasinoID() {
		return casinoID;
	}

	public void setCasinoID(String casinoID) {
		this.casinoID = casinoID;
	}
}