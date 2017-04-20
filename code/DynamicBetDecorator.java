/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac DynamicBetDecorator.java
 *  
 *  Extended functionality for dynamic bets.
 *
 ******************************************************************************/

public class DynamicBetDecorator implements GameDecorator {

	public double minBet;
	public double maxBet;

	DynamicBetDecorator(Game g, double min, double max) {
		super(g);
		this.minBet = min;
		this.maxBet = max;
	}

	public bool checkBet(double bet) {
		return (minBet < bet && bet < maxBet);
	}

	// Figure out how playGame will work
	//@Override
	//public void playGame(String playerID, double bet) {
	//	System.out.print("It looks like playGame was not implemented correctly, in SimpleGame.")
	//}
}