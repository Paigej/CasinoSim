/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac ColorGameDecorator.java
 *  
 *  Extended functionality for color games.
 *
 ******************************************************************************/

import java.util.*;

public class ColorGameDecorator implements GameDecorator {

	private ArrayList<String> choiceList;

	DynamicBetDecorator(Game g, ArrayList<String> choice) {
		super(g);
		this.choiceList = choice;
	}

	public bool checkChoice(double bet) {
		return (choiceList.contains(bet));
	}

	// Figure out how playGame will work
	//@Override
	//public void playGame(String playerID, double bet) {
	//	System.out.print("It looks like playGame was not implemented correctly, in SimpleGame.")
	//}
}