/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac GameDecorator.java
 *  
 *  Implements GameDecorator, the root for all extended functionality.
 *
 ******************************************************************************/

public class GameDecorator extends Game {

	protected Game game;

	GameDecorator(Game g) {
		this.game = g;
	}

	@Override
		public void playGame(String playerID, double bet) {
		System.out.print("It looks like playGame was not implemented correctly, in GameDecorator.");
	}
}