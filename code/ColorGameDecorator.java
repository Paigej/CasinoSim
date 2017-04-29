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
			return (numberOfSpaces * payoffRate * bet); 
			
		}
		else if (boardNumber == randomBoardNumber)
		{
			return ((numberOfSpaces / numberOfColors) * payoffRate * bet); 
		}
		else if (color == randomColor)
		{
			return (numberOfColors * payoffRate * bet); 
		}
		else
		{
			return (0.0 - bet);
		}
	}
}