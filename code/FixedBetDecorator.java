import java.util.Random;

/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac FixedBetDecorator.java
 *  
 *  Extended functionality for fixed bets.
 *
 ******************************************************************************/

public class FixedBetDecorator extends GameDecorator {

	private double fixedBetAmount;
	private int numberOfOutcomes = 9;
	private double payoffRate = 0.8;
	Random rand = new Random();


	FixedBetDecorator(String id, Casino owningCasino, String name, double fixedBetAmount) {
		super(id, owningCasino, name);
		this.fixedBetAmount = fixedBetAmount;
	}
	
	
	public boolean checkBet(double bet) {
		return (fixedBetAmount == bet);
	}

	@Override
	public double playGame(Player playerID, double bet) {
		int randomNumber = rand.nextInt(numberOfOutcomes) + 1;
		if (randomNumber == 1)
		{
			//Win
			return (payoffRate * numberOfOutcomes) * bet;
		}
		else
		{
			return (0.0 - bet);
		}
	}
}