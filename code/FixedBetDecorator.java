/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac FixedBetDecorator.java
 *  
 *  Extended functionality for fixed bets.
 *
 ******************************************************************************/

public class FixedBetDecorator implements GameDecorator {

	public double fixedBetAmount;

	DynamicBetDecorator(Game g, double bet) {
		super(g);
		this.fixedBetAmount = bet;
	}

	public bool checkBet(double bet) {
		return (fixedBetAmount == bet);
	}

	// Figure out how playGame will work
	//@Override
	//public void playGame(String playerID, double bet) {
	//	System.out.print("It looks like playGame was not implemented correctly, in SimpleGame.")
	//}
}