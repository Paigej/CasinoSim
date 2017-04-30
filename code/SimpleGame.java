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
			double winnings = ((oddsOfWinPercentage * payoffRate) * bet);
			this.getOwningCasino().getOwnerID().increaseBalance(- winnings);
			this.getOwningCasino().income = this.getOwningCasino().income - winnings;
			this.getOwningCasino().loss = this.getOwningCasino().loss + winnings;
			return winnings;
		}
		else
		{
			this.getOwningCasino().getOwnerID().increaseBalance(bet);
			this.getOwningCasino().income = this.getOwningCasino().income + bet;
			this.getOwningCasino().loss = this.getOwningCasino().loss - bet;
			return (0.0 - bet);
		}
	}
}