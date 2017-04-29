
public class PrettyPrint {
	
	public static String prettyPrintGame(Game game)
	{
		if (game instanceof SimpleGame)
		{
			return (game.name +": Simple Game | " + game.getOwningCasino().name);
		}
		else if (game instanceof DynamicBetDecorator)
		{
			DynamicBetDecorator gameMadeStrict = (DynamicBetDecorator) game;
			return (gameMadeStrict.name +": Strict Bet Game | " + gameMadeStrict.getOwningCasino().name 
			+ " | Minbet: "+ gameMadeStrict.getMinBet()+ " | Maxbet: " + gameMadeStrict.getMaxBet());
		}
		else if (game instanceof FixedBetDecorator)
		{
			FixedBetDecorator gameMadeFixed = (FixedBetDecorator) game;
			return (gameMadeFixed.name +": Fixed Bet Game | " + gameMadeFixed.getOwningCasino().name 
			+ " | Fixed bet: "+ gameMadeFixed.getFixedBetAmount());
		}
		else if (game instanceof ColorGameDecorator)
		{
			ColorGameDecorator gameMadeColor = (ColorGameDecorator) game;
			return (gameMadeColor.name +": Color Bet Game | " + gameMadeColor.getOwningCasino().name 
			+ " | Number of colors on board: "+ gameMadeColor.getNumberOfColors()+ " | Number of spaces per color " + (gameMadeColor.getNumberOfSpaces() / 2));
		}
		else
		{
			return ("PRINT ERROR");
		}
	}
	
	public static String prettyPrintCasinoForPlayer(Casino casino)
	{
		return (casino.name + " | Owner: "+casino.getOwnerID()+" | AvailableGames: "+casino.getGamesInCasino().size()+" | Casino Worth: "+ (100000.0 +casino.income));
	}
}