/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac SimpleGame.java
 *  
 *  Implements SimpleGame, a requirement for the Decorator design pattern.
 *
 ******************************************************************************/

import java.util.Random;


public class SimpleGame extends Game {
	
	private double oddsOfWinPercentage = 37;
	private double payoffRate = 0.8;
	Random rand = new Random();

	SimpleGame(Casino owningCasino, String name) {
		super(owningCasino, name);
	}

	@Override
	public double playGame(Player playerID, double bet) {
		int randomNumber = rand.nextInt(100) + 1;
		if (randomNumber < oddsOfWinPercentage)
		{
			//Win
			return ((oddsOfWinPercentage * payoffRate) * bet);
		}
		else
		{
			return (0.0 - bet);
		}
	}
}