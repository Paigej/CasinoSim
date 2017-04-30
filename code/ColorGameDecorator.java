import java.util.Random;

/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac ColorGameDecorator.java
 *  
 *  Extended functionality for color games.
 *
 ******************************************************************************/



public class ColorGameDecorator extends GameDecorator {
	
	private int numberOfSpaces = 39;
	private double numberOfColors = 2;
	private double payoffRate = 0.8;
	
	Random rand = new Random();
	
	ColorGameDecorator(Casino owningCasino, String name) {
		super(owningCasino, name);
	}


	public int getNumberOfSpaces() {
		return numberOfSpaces;
	}


	public void setNumberOfSpaces(int numberOfSpaces) {
		this.numberOfSpaces = numberOfSpaces;
	}


	public double getNumberOfColors() {
		return numberOfColors;
	}


	public void setNumberOfColors(double numberOfColors) {
		this.numberOfColors = numberOfColors;
	}


	public double playGame(Player playerID, double bet, int color, int boardNumber) 
	{
		int randomBoardNumber = rand.nextInt(39) + 1;
		int randomColor =  rand.nextInt(2) + 1;
		if (color == randomColor && boardNumber == randomBoardNumber)
		{
			System.out.println("Correct Spot on Board!! MAX PAYOUT");
			double winnings = (numberOfSpaces * payoffRate * bet); 
			this.getOwningCasino().getOwnerID().increaseBalance(- winnings);
			this.getOwningCasino().income = this.getOwningCasino().income - winnings;
			this.getOwningCasino().loss = this.getOwningCasino().loss + winnings;
			return winnings;
			
		}
		else if (boardNumber == randomBoardNumber)
		{
			System.out.println("Correct Number");
			double winnings = ((numberOfSpaces / numberOfColors) * payoffRate * bet); 
			this.getOwningCasino().getOwnerID().increaseBalance(- winnings);
			this.getOwningCasino().income = this.getOwningCasino().income - winnings;
			this.getOwningCasino().loss = this.getOwningCasino().loss + winnings;
			return winnings;
		}
		else if (color == randomColor)
		{
			System.out.println("Correct color!");
			double winnings = (numberOfColors * payoffRate * bet); 
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