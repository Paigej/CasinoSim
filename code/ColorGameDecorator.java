/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac ColorGameDecorator.java
 *  
 *  Extended functionality for color games.
 *
 ******************************************************************************/

import java.util.*;

public class ColorGameDecorator extends GameDecorator {

	private ArrayList<String> choiceList;

	//What is this supposed to be doing?
	DynamicBetDecorator(Game g, ArrayList<String> choice) {
		super(g);
		this.choiceList = choice;
	}

	public boolean checkChoice(double bet) {
		return (choiceList.contains(bet));
	}

	// Figure out how playGame will work
	//@Override
	//public void playGame(String playerID, double bet) {
	//	System.out.print("It looks like playGame was not implemented correctly, in SimpleGame.")
	//}
}