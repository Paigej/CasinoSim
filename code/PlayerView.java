import java.util.ArrayList;
import java.util.Scanner;

public class PlayerView {
	private String userID; //Name of current user
	private double userBalance; // current user's balance
	
	private static Scanner scan; //class that can take in input from user
	private Player linkToPlayer;
	
	public ArrayList<Owner> defaultOwners = new ArrayList<Owner>();
	public ArrayList<String> defaultBusinessNames = new ArrayList<String>();
	
	/*
	 * Since this is a view class it receives info about the user it is displaying to
	 * so the constructor below takes in an Owner object
	 */
	PlayerView(Player playerInfo)  
	{
		this.linkToPlayer = playerInfo;
		this.userID = playerInfo.username;
		this.userBalance = playerInfo.getBalance();
		initializeDefaultClasses();
	}
	
	public void initializeDefaultClasses()
	{
		Owner ElonMusk = new Owner("ElonMusk78", "dorwassp", "elmo0457@spacex.com");
		Owner MarkZuckerberg = new Owner("MarkyMark", "qwertyuiop", "Mark.Zuckerberg@facebook.com");
		Owner BillGates = new Owner("IllGates", "PCMasterRace", "originalgangSTAR@microsoft.com");
		
		Casino Bellagio = new Casino("The Bellagio", ElonMusk.username);
		Casino Aria = new Casino("The Aria", ElonMusk.username);
		Casino Wynn = new Casino("The Wynn", MarkZuckerberg.username);
		Casino CeasersPalace = new Casino("Ceaser's Palace", BillGates.username);
		Casino MonteCarlo = new Casino("The MonteCarlo", BillGates.username);
		
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
	

	public void displayMainPlayerScreen ()
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
		mainPlayerScreenPrompt(defaultBusinesses);

	}
	
	//NOTE THIS SHOULD ONLY BE CALLED AFTER DISPLAYMAINPLAYERSCREEN()
	public void mainPlayerScreenPrompt (ArrayList<Business> businesses)
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
			else
			{
				System.out.println("Please type the name of one of the businesses above.");
			}
			
		}
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
			SimpleGame gameMadeSimple = (SimpleGame) game;
			System.out.println(gameMadeSimple.playGame(linkToPlayer, 500.0));
		}
		else if (game instanceof ColorGameDecorator)
		{
			ColorGameDecorator gameMadeColor = (ColorGameDecorator) game;
			System.out.println(gameMadeColor.playGame(linkToPlayer, 600.0, 1, 7));
		}
		else if (game instanceof FixedBetDecorator)
		{
			FixedBetDecorator gameMadeFixed = (FixedBetDecorator) game;
			System.out.println(gameMadeFixed.playGame(linkToPlayer, 700.0));
		}
		else if (game instanceof DynamicBetDecorator)
		{
			DynamicBetDecorator gameMadeDynamic = (DynamicBetDecorator) game;
			System.out.println(gameMadeDynamic.playGame(linkToPlayer, 800.0));
		}
		else
		{
			System.out.println("******COULD NOT DETERMINE GAME TYPE" +game + " " + game.name);
		}
		repeatPlay(game);
		displayMainPlayerScreen();
	}

	private void repeatPlay(Game game) {
		System.out.println("Play Agin?");
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
