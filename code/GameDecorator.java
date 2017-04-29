/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac GameDecorator.java
 *  
 *  Implements GameDecorator, the root for all extended functionality.
 *
 ******************************************************************************/

public class GameDecorator extends Game {

	protected static Game game;
	
	GameDecorator(Casino owningCasino, String name) {
		super(owningCasino, name);
	}

}