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

	DynamicBetDecorator(String id, Casino owningCasino, String name, double _minBet, double _maxBet) {
		super(id, owningCasino, name);
		this.minBet = _minBet;
		this.maxBet = _maxBet;
	}

	public boolean checkBet(double bet) {
		return (minBet < bet && bet < maxBet);
	}
	
	@Override
	public double playGame(Player playerID, double bet) {
		int randomNumber = rand.nextInt(100) + 1;
		if (randomNumber < (100 * oddsOfWin))
		{
			//Win
			return (payoutMultiplier * bet);
		}
		else
		{
			return (0.0 - bet);
		}
	}
}