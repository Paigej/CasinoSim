import java.util.Random;

/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac DynamicBetDecorator.java
 *  
 *  Extended functionality for dynamic bets.
 *
 ******************************************************************************/

public class DynamicBetDecorator extends GameDecorator {
	private double minBet;
	private double maxBet;
	private double oddsOfWin = 0.37;
	private double payoutMultiplier = 2.5;
	Random rand = new Random();

	DynamicBetDecorator(Casino owningCasino, String name, double _minBet, double _maxBet) {
		super(owningCasino, name);
		this.minBet = _minBet;
		this.maxBet = _maxBet;
	}

	public double getMinBet() {
		return minBet;
	}

	public void setMinBet(double minBet) {
		this.minBet = minBet;
	}

	public double getMaxBet() {
		return maxBet;
	}

	public void setMaxBet(double maxBet) {
		this.maxBet = maxBet;
	}

	public boolean checkBet(double bet) {
		return (minBet < bet && bet < maxBet);
	}
	
	@Override
	public double playGame(Player playerID, double bet) {
		int randomNumber = rand.nextInt(100) + 1;
		if (randomNumber < (100 * oddsOfWin))
		{
			double winnings = (payoutMultiplier * bet);
			this.getOwningCasino().getOwnerID().increaseBalance(- winnings);
			this.getOwningCasino().income = this.getOwningCasino().income - winnings;
			this.getOwningCasino().loss = this.getOwningCasino().loss + winnings;
			return winnings;
		}
		else
		{
			this.getOwningCasino().getOwnerID().increaseBalance(- bet);
			this.getOwningCasino().income = this.getOwningCasino().income - bet;
			this.getOwningCasino().loss = this.getOwningCasino().loss + bet;
			return (0.0 - bet);
		}
	}
}