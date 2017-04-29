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
	
	GameDecorator(String id, Casino owningCasino, String name) {
		super(id, owningCasino, name);
	}

}