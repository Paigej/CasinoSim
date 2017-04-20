/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac GameDecorator.java
 *  
 *  Implements GameDecorator, the root for all extended functionality.
 *
 ******************************************************************************/

public class GameDecorator implements Game {

	protected Game game;

	GameDecorator(Game g) {
		this.game = g;
	}
}