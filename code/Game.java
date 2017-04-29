/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac Game.java
 *  
 *  Implements the interface Game class.
 *
 ******************************************************************************/

public abstract class Game {

	private Casino owningCasino;
	// Figure out the probability table --> private probTable;

	public String name;
	public double costToBuild;
	public int seatsAvailable;
	public int seatsOccupied;
	
	Game(Casino _owningCasino, String _name) {
		this.setOwningCasino(_owningCasino);
		this.name = _name;
	}

	public double playGame(Player playerID, double bet) {
		System.out.println("*******ERROR: DEFAULT GAME PLAYGAME CALLED");
		return 0;
	}


	public Casino getOwningCasino() {
		return owningCasino;
	}

	public void setOwningCasino(Casino owningCasino) {
		this.owningCasino = owningCasino;
	}
}