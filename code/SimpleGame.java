/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac SimpleGame.java
 *  
 *  Implements SimpleGame, a requirement for the Decorator design pattern.
 *
 ******************************************************************************/

public class SimpleGame implements Game {

	SimpleGame(String id, String casinoID, String name) {
		super(id, casinoID, name);
	}

	@Override
	public void playGame(String playerID, double bet) {
		System.out.print("It looks like playGame was not implemented correctly, in SimpleGame.")
	}
}