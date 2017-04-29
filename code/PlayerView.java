import java.util.ArrayList;
import java.util.Scanner;

public class PlayerView {
	private String userID; //Name of current user
	private double userBalance; // current user's balance
	
	private static Scanner scan; //class that can take in input from user
	private Player linkToPlayer;
	
	public ArrayList<Owner> defaultOwners = new ArrayList<Owner>();
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
	
	/*
	 * Pre-req: NA
	 * 
	 * Initial message displayed to Owner. This is based of the UI mock-up in 
	 * part2.pdf
	 * Loops through User's businesses and displays info about each one
	 * 
	 * Post: NA
	 */
	public void displayMainPlayerScreen ()
	{
		System.out.println("Casino Browser");
		System.out.println("Current Worth: " +  userBalance);
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Casino Name | Owner | NumberOfGames | OwnerWorth");

		for(int i = 0; i < defaultOwners.size(); i = i + 1) 
		{
			for (Business currentBusiness: defaultOwners.get(i).businesses)
			{
				System.out.println(currentBusiness.name);
			}
		}

	}
	
	/*
	 * Pre-req: displayManageBusinessScreen should be called
	 * 
	 * Takes in input from Owner about editing or buying a business
	 * 
	 * Post: Edit or buy screen is displayed
	 */
	
	
}
