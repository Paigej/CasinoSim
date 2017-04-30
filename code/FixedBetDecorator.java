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


	FixedBetDecorator(Casino owningCasino, String name, double fixedBetAmount) {
		super(owningCasino, name);
		this.fixedBetAmount = fixedBetAmount;
	}
	
	
	public double getFixedBetAmount() {
		return fixedBetAmount;
	}


	public void setFixedBetAmount(double fixedBetAmount) {
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
			double winnings = (payoffRate * numberOfOutcomes) * bet;
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