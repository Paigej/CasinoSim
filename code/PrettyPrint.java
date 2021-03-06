
public class PrettyPrint {
	
	public static void prettyPrintGame(Game game)
	{
		if (game instanceof SimpleGame)
		{
			System.out.println(game.name +": Simple Game | " + game.getOwningCasino().name);
		}
		else if (game instanceof DynamicBetDecorator)
		{
			DynamicBetDecorator gameMadeStrict = (DynamicBetDecorator) game;
			System.out.println(gameMadeStrict.name +": Strict Bet Game | " + gameMadeStrict.getOwningCasino().name 
			+ " | Minbet: "+ gameMadeStrict.getMinBet()+ " | Maxbet: " + gameMadeStrict.getMaxBet());
		}
		else if (game instanceof FixedBetDecorator)
		{
			FixedBetDecorator gameMadeFixed = (FixedBetDecorator) game;
			System.out.println(gameMadeFixed.name +": Fixed Bet Game | " + gameMadeFixed.getOwningCasino().name 
			+ " | Fixed bet: "+ gameMadeFixed.getFixedBetAmount());
		}
		else if (game instanceof ColorGameDecorator)
		{
			ColorGameDecorator gameMadeColor = (ColorGameDecorator) game;
			System.out.println(gameMadeColor.name +": Color Bet Game | " + gameMadeColor.getOwningCasino().name 
			+ " | Number of colors on board: "+ gameMadeColor.getNumberOfColors()+ " | Number of spaces per color " + (gameMadeColor.getNumberOfSpaces() / 2));
		}
		else
		{
			System.out.println("PRINT ERROR");
		}
	}
	
	public static String prettyPrintCasinoForPlayer(Casino casino)
	{
		//return (casino.name + " | Owner: "+casino.getOwnerID().username+" | AvailableGames: "+casino.getGamesInCasino().size()+" | Casino Worth: "+ (100000.0 +casino.income));
		System.out.format("%-15s | %-10s | %-13s | $%-4s\n", casino.name, casino.getOwnerID().username , casino.getGamesInCasino().size(),(100000.0 +casino.income));
		//return ("%-13s | %-13s | %-13s | Casino Worth: %-4s\n", casino.name, casino.getOwnerID().username , casino.getGamesInCasino().size(),(100000.0 +casino.income));
		return"";
	}
}