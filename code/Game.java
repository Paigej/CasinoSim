/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac Game.java
 *  
 *  Implements the interface Game class.
 *
 ******************************************************************************/

public interface Game {

	public String getID();
	public void playGame(String playerID, double bet);
}