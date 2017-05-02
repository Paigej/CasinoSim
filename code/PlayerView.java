import java.util.ArrayList;
import java.util.Scanner;

public class PlayerView {
	private double userBalance; // current user's balance
	
	private static Scanner scan; //class that can take in input from user
	private Player linkToPlayer;
	
	public ArrayList<Owner> defaultOwners = new ArrayList<Owner>();
	public ArrayList<String> defaultBusinessNames = new ArrayList<String>();
	private Scanner reader;
	
	/*
	 * Since this is a view class it receives info about the user it is displaying to
	 * so the constructor below takes in an Owner object
	 */
	PlayerView(Player playerInfo)  
	{
		this.linkToPlayer = playerInfo;
		this.userBalance = playerInfo.getBalance();
		initializeDefaultClasses();
	}
	
	public void initializeDefaultClasses()
	{
		Owner ElonMusk = new Owner("ElonMusk78", "dorwassp", "elmo0457@spacex.com");
		Owner MarkZuckerberg = new Owner("MarkyMark", "qwertyuiop", "Mark.Zuckerberg@facebook.com");
		Owner BillGates = new Owner("IllGates", "PCMasterRace", "originalgangSTAR@microsoft.com");
		
		Casino Bellagio = new Casino("The Bellagio", ElonMusk);
		Casino Aria = new Casino("The Aria", ElonMusk);
		Casino Wynn = new Casino("The Wynn", MarkZuckerberg);
		Casino CeasersPalace = new Casino("Ceaser's Palace", BillGates);
		Casino MonteCarlo = new Casino("The MonteCarlo", BillGates);
		
		SimpleGame CardDrawing = new SimpleGame(Bellagio, "Shot in the dark draw");
		ColorGameDecorator Roullette = new ColorGameDecorator(Bellagio, "Jungle Roullette");
		FixedBetDecorator Slots = new FixedBetDecorator(Aria, "007 Slots", 70.0);
		FixedBetDecorator Slots2 = new FixedBetDecorator(Wynn, "Tron Slots", 120.0);
		DynamicBetDecorator MachinePoker = new DynamicBetDecorator(Wynn, "Poker of the Caribean", 10.0, 500.0);
		DynamicBetDecorator CelebrityPoker = new DynamicBetDecorator(Wynn, "High Stakes WPT Poker", 1000.0, 15000.0);
		FixedBetDecorator Slots3 = new FixedBetDecorator(CeasersPalace, "Back to the Future Slots", 5.0);
		ColorGameDecorator Roullette2 = new ColorGameDecorator(MonteCarlo, "Paris Roullette");

		ArrayList<Game> BellagioGames = new ArrayList<Game>();
		ArrayList<Game> AriaGames = new ArrayList<Game>();
		ArrayList<Game> WynnGames = new ArrayList<Game>();
		ArrayList<Game> CeasersPalaceGames = new ArrayList<Game>();
		ArrayList<Game> MonteCarloGames = new ArrayList<Game>();
		
		BellagioGames.add(CardDrawing);
		BellagioGames.add(Roullette);
		
		AriaGames.add(Slots);
		
		WynnGames.add(Slots2);
		WynnGames.add(MachinePoker);
		WynnGames.add(CelebrityPoker);
		
		CeasersPalaceGames.add(Slots3);
		
		MonteCarloGames.add(Roullette2);
		
		
		Bellagio.setGamesInCasino(BellagioGames);
		Aria.setGamesInCasino(AriaGames);
		Wynn.setGamesInCasino(WynnGames);
		CeasersPalace.setGamesInCasino(CeasersPalaceGames);
		MonteCarlo.setGamesInCasino(MonteCarloGames);
		
		ArrayList<Business> ElonsBusinesses = new ArrayList<Business>();
		ArrayList<Business> MarksBusinesses = new ArrayList<Business>();
		ArrayList<Business> BillsBusinesses = new ArrayList<Business>();
		
		ElonsBusinesses.add(Bellagio);
		ElonsBusinesses.add(Aria);
		MarksBusinesses.add(Wynn);
		BillsBusinesses.add(CeasersPalace);
		BillsBusinesses.add(MonteCarlo);
		
		ElonMusk.setBusinesses(ElonsBusinesses);
		MarkZuckerberg.setBusinesses(MarksBusinesses);
		BillGates.setBusinesses(BillsBusinesses);
		
		ElonMusk.setBalance(1467803);
		MarkZuckerberg.setBalance(7005890543.0);
		BillGates.setBalance(56783420050.0);

		defaultOwners.add(ElonMusk);
		defaultOwners.add(MarkZuckerberg);
		defaultOwners.add(BillGates);
		
	}
	

	public int displayMainPlayerScreen ()
	{
		System.out.println("Casino Browser");
		System.out.println("Current Worth: " +  userBalance);
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Casino Name | Owner | NumberOfGames | OwnerWorth");
		defaultBusinessNames.clear();
		ArrayList<Business> defaultBusinesses = new ArrayList<Business>();
		for(int i = 0; i < defaultOwners.size(); i = i + 1) 
		{
			for (Business currentBusiness: defaultOwners.get(i).businesses)
			{
				defaultBusinessNames.add(currentBusiness.name);
				defaultBusinesses.add(currentBusiness);
				if (currentBusiness instanceof Casino)
				{
				Casino currentCasino = (Casino) currentBusiness;
				System.out.println(PrettyPrint.prettyPrintCasinoForPlayer(currentCasino));
				}
				else
				{
					System.out.println("REQUIRES BUSINESS EXTENDIBILITY");
				}
			}
		}
		return mainPlayerScreenPrompt(defaultBusinesses);
		
	}
	
	//NOTE THIS SHOULD ONLY BE CALLED AFTER DISPLAYMAINPLAYERSCREEN()
	public int mainPlayerScreenPrompt (ArrayList<Business> businesses)
	{
		boolean validResponse = false;
		System.out.println("Please choose a casino to enter:");
		scan = new Scanner(System.in);
		while (validResponse == false)
		{
			String userSelection = scan.nextLine();
			int positionInList = defaultBusinessNames.indexOf(userSelection);
			if (positionInList != -1)
			{
				enterBusiness(businesses.get(positionInList));
				validResponse = true;
			}
			else if (userSelection.toLowerCase().equals("exit"))
			{
				return -1;
			}
			else
			{
				System.out.println("Please type the name of one of the businesses above.");
			}
			
		}
		return -1;
	}

	private void enterBusiness(Business business) 
	{
		
		if (business instanceof Casino)
		{
			Casino currentCasino = (Casino) business;
			enterCasino(currentCasino);
		}
		else
		{
			System.out.println("REQUIRES BUSINESS EXTENDIBILITY");
		}
	}
	private void enterCasino(Casino casino)
	{
		System.out.println(PrettyPrint.prettyPrintCasinoForPlayer(casino));
		System.out.println("--------------------");
		ArrayList<Game> casinoGames = casino.getGamesInCasino();
		ArrayList<String> casinoGameNames = new ArrayList<String>();
		for (Game currentGame : casinoGames)
		{
			casinoGameNames.add(currentGame.name);
			System.out.println(PrettyPrint.prettyPrintGame(currentGame));
		}
		gameScreenPrompt(casinoGames, casinoGameNames);
	}

	private void gameScreenPrompt(ArrayList<Game> casinoGames, ArrayList<String> casinoGameNames) 
	{
		boolean validResponse = false;
		System.out.println("Please choose a game to enter or type 'Leave' to leave casino:");
		scan = new Scanner(System.in);
		while (validResponse == false)
		{
			String userSelection = scan.nextLine();
			int positionInList = casinoGameNames.indexOf(userSelection);
			if (positionInList != -1)
			{
				determineWhichPlayGame(casinoGames.get(positionInList));
				//System.out.println(casinoGames.get(positionInList).playGame(linkToPlayer, 50.0));
				validResponse = true;
			}
			else if (userSelection.toLowerCase().equals("leave"))
			{
				displayMainPlayerScreen();
				validResponse = true;
			}
			else
			{
				System.out.println("Please type the name of one of the game's names above or 'Leave'.");
			}
			
		}
	}

	private void determineWhichPlayGame(Game game) 
	{
		if (game instanceof SimpleGame)
		{
			System.out.println("How much would you like to bet? Current Worth: "+ linkToPlayer.getBalance());
			Double doubBet = 0.0;
			boolean validResponse = false;
			while (validResponse == false)
			{
				String bet  = scan.nextLine();
				try
				{
				  doubBet = Double.parseDouble(bet);
				  if (doubBet > 0.0 && doubBet < userBalance)
				  {
					  validResponse = true;
				  }
				}
				catch(NumberFormatException e)
				{
				  System.out.println("Please specify a number greater than 0 and within your worth");
				}
			}
			SimpleGame gameMadeSimple = (SimpleGame) game;
			double winnings = (gameMadeSimple.playGame(linkToPlayer, doubBet));
			if (winnings < 0)
			{
				System.out.println("Sorry you lost $"+winnings);
			}
			else
			{
				System.out.println("You won $"+winnings+"!");
			}
			userBalance = userBalance + winnings;
			linkToPlayer.setBalance(userBalance);
		}
		else if (game instanceof ColorGameDecorator)
		{
			System.out.println("How much would you like to bet? Current Worth: "+ linkToPlayer.getBalance());
			Double doubBet = 0.0;
			boolean validResponse = false;
			while (validResponse == false)
			{
				String bet  = scan.nextLine();
				try
				{
				  doubBet = Double.parseDouble(bet);
				  if (doubBet > 0.0 && doubBet < userBalance)
				  {
					  validResponse = true;
				  }
				  else
				  {
					  System.out.println("Please specify a number greater than 0 and within your worth");
				  }
				}
				catch(NumberFormatException e)
				{
				  System.out.println("Please specify a number greater than 0 and within your worth");
				}
			}
			validResponse = false;
			int colorCode = -1;
			System.out.println("What color would you like to bet on, Black or Red:");
			while (validResponse == false)
			{
				String color  = scan.nextLine();
				if (color.toLowerCase().equals("black"))
				{
					colorCode = 1;
					validResponse = true;
				}
				else if (color.toLowerCase().equals("red"))
				{
					colorCode = 2;
					validResponse = true;
				}
				else
				{
				  System.out.println("Please type 'Black' or 'Red'");
				}
			}
			System.out.println("What space would you like to bet on: 1-19?");
			String space = "";
			int intSpace = 0;
			validResponse = false;
			reader = new Scanner(System.in);
			while (validResponse == false)
			{
				space = reader.nextLine();
				try
				{
					intSpace = Integer.parseInt(space);
					if (intSpace > 0 && intSpace < 20)
					{
						validResponse = true;
					}
					else
					{
						System.out.println("Please specify a number between 1 and 19.");
					}
				}
				catch(NumberFormatException e)
				{
				  System.out.println("Please specify a number between 1 and 19.");
				}
			}
			ColorGameDecorator gameMadeColor = (ColorGameDecorator) game;
			double winnings = (gameMadeColor.playGame(linkToPlayer, doubBet, colorCode, intSpace));
			if (winnings < 0)
			{
				System.out.println("Sorry you lost $"+winnings);
			}
			else
			{
				System.out.println("You won $"+winnings+"!");
			}
			userBalance = userBalance + winnings;
			linkToPlayer.setBalance(userBalance);
		}
		else if (game instanceof FixedBetDecorator)
		{
			FixedBetDecorator gameMadeFixed = (FixedBetDecorator) game;
			Double fixedBet = gameMadeFixed.getFixedBetAmount();
			System.out.println("The bet for this game is: "+fixedBet);
			if (fixedBet < userBalance)
			{
				double winnings =(gameMadeFixed.playGame(linkToPlayer, fixedBet));
				if (winnings < 0)
				{
					System.out.println("Sorry you lost $"+winnings);
				}
				else
				{
					System.out.println("You won $"+winnings+"!");
				}
				userBalance = userBalance + winnings;
				linkToPlayer.setBalance(userBalance);
			}
			else
			{
				System.out.println("You do not have the required funds: "+ userBalance);
			}
		}
		else if (game instanceof DynamicBetDecorator)
		{
			DynamicBetDecorator gameMadeDynamic = (DynamicBetDecorator) game;
			double min = gameMadeDynamic.getMinBet();
			double max = gameMadeDynamic.getMaxBet();
			
			System.out.println("How much would you like to bet? Current Worth: "+ linkToPlayer.getBalance());
			Double doubBet = 0.0;
			boolean validResponse = false;
			while (validResponse == false)
			{
				String bet  = scan.nextLine();
				try
				{
				  doubBet = Double.parseDouble(bet);
				  if (doubBet > min && doubBet < userBalance)
				  {
					  if (doubBet < max)
					  {
					  validResponse = true;
					  }
				  }
				}
				catch(NumberFormatException e)
				{
				  System.out.println("This game requires a minimum bet of "+min+" and a maximum of "+max+". "
				  		+ "Please specify an amount in this range within your worth.");
				}
			}
			
			double winnings =(gameMadeDynamic.playGame(linkToPlayer, 800.0));
			if (winnings < 0)
			{
				System.out.println("Sorry you lost $"+winnings);
			}
			else
			{
				System.out.println("You won $"+winnings+"!");
			}
			userBalance = userBalance + winnings;
			linkToPlayer.setBalance(userBalance);
		}
		else
		{
			System.out.println("******COULD NOT DETERMINE GAME TYPE" +game + " " + game.name);
		}
		repeatPlay(game);
		displayMainPlayerScreen();
	}

	private void repeatPlay(Game game) {
		System.out.println("Play Again?");
		scan = new Scanner(System.in);
		while (true)
		{
			String userSelection = scan.nextLine();
			if (userSelection.toLowerCase().equals("yes"))
			{
				determineWhichPlayGame(game);
				return;
			}
			else if (userSelection.toLowerCase().equals("no"))
			{
				displayMainPlayerScreen();
				return;
			}
			else
			{
				System.out.println("Please type 'yes' to play again or 'no' to leave.");
			}
			
		}
		
	}
	
}
