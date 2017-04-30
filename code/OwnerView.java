/******************************************************************************
 *  Author(s):    Michael Condon
 *
 *  Compilation:  javac OwnerView.java
 *  
 *  Displays UI for Owner user (Command-line UI version)
 *
 ******************************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class OwnerView 
{
	private String userID; //Name of current user
	private double userBalance; // current user's balance
	public ArrayList<Business> userBusinesses; //list of businesses owned by current user
	
	private static Scanner scan; //class that can take in input from user
	public ArrayList<String> businessesAvailableToPurchase = new ArrayList<String>();
	private Owner linkToOwner;

	/*
	 * Since this is a view class it receives info about the user it is displaying to
	 * so the constructor below takes in an Owner object
	 */
	OwnerView(Owner ownerInfo)  
	{
		this.linkToOwner = ownerInfo;
		this.userID = ownerInfo.username;
		this.userBalance = ownerInfo.getBalance();
		this.userBusinesses = ownerInfo.getBusinesses();
		businessesAvailableToPurchase.add("Casino");
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
	public void displayManageBusinessScreen ()
	{
		System.out.println("Hello " + userID + ", manage your businesses!");
		System.out.println("Current Worth: " +  userBalance);
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Business Name | Business Type | Net gain/loss | Open | Protect | Passcode");

		for(int i = 0; i < userBusinesses.size(); i = i + 1) 
		{
			System.out.println(userBusinesses.get(i).name +" | " + 
					userBusinesses.get(i).getClass() + " | " + userBusinesses.get(i).getNetGain()
					+ " | " + userBusinesses.get(i).open + " | " +
					userBusinesses.get(i).getIsPrivate() + " | " + userBusinesses.get(i).getPasscode());
		}

	}
	
	/*
	 * Pre-req: displayManageBusinessScreen should be called
	 * 
	 * Takes in input from Owner about editing or buying a business
	 * 
	 * Post: Edit or buy screen is displayed
	 */
	public void displayManageBusinessOptions()
	{
		System.out.println("Would you like to edit a business or buy one?");
		scan = new Scanner(System.in);
		String userSelection = scan.nextLine();// Scans the next token of the input as a String.
		if (userSelection.indexOf("edit") != -1 || userSelection.indexOf("Edit") != -1)
		{
			choseABusinessToEdit();
			return;
		}
		else if (userSelection.indexOf("Buy") != -1 || userSelection.indexOf("buy") != -1)
		{
			createBusiness();
			return;
		}
		else
		{
			System.out.println("Please type 'Edit' or 'Buy'");
			displayManageBusinessOptions();
			return;
		}
	}
	
	/*
	 * pre-req: user has chosen to edit one of their current businesses
	 * 
	 * Displays list of businesses and prompts user to enter a business name.
	 * Will repeat until user has entered a valid response
	 * If there are no businesses user is asked to buy one
	 * if user says yes we are taken to buyBusiness screen
	 * if no we are taken back to manage business screen
	 * 
	 * post: createBusiness() is called or manage business screen is displayed
	 * 
	 */
	
	public void choseABusinessToEdit()
	{
		if (userBusinesses.size() == 0)
		{
			System.out.println("You have no businesses. Would you like to buy one?");
			boolean validResponse = false;
			while (validResponse == false)
			{
				scan = new Scanner(System.in);
				String userDecision = scan.nextLine();
				if (userDecision.indexOf("Y") != -1 || userDecision.indexOf("y") != -1)
				{
					createBusiness();
					validResponse = true;
				}
				else if (userDecision.indexOf("N") != -1 || userDecision.indexOf("n") != -1)
				{
					validResponse = true;
					displayManageBusinessScreen();
					displayManageBusinessOptions();
					return;
					
				}
				else
				{
					System.out.println("Please type 'Yes' or 'No'");
				}
			}
		}
		else
		{
			System.out.println("Please type the name of the business:");
			ArrayList<String> businessesNames = new ArrayList<String>();
			for(int i = 0; i < userBusinesses.size(); i = i + 1) 
			{
				System.out.println(userBusinesses.get(i).name +" | " + 
						userBusinesses.get(i).getClass() + " | " + userBusinesses.get(i).getNetGain()
						+ " | " + userBusinesses.get(i).open + " | " +
						userBusinesses.get(i).getIsPrivate() + " | " + userBusinesses.get(i).getPasscode());
				businessesNames.add(userBusinesses.get(i).name);
			}
			boolean validResponse = false;
			while (validResponse == false)
			{
				scan = new Scanner(System.in);
				String businessToBeEdited = scan.nextLine();
				if (businessesNames.contains(businessToBeEdited))
				{
					int positionOfBusinessInArray = businessesNames.indexOf(businessToBeEdited);
					modifyBusiness(userBusinesses.get(positionOfBusinessInArray));
					return;
				}
				else
				{
					System.out.println("Please enter a valid business name.");
				}
			}
		}
	}
	
	public void updateOwner()
	{
		linkToOwner.updateOwner(userID, userBalance, userBusinesses);
	}
	
	public void sellBusiness(Business businessToBeSold)
	{
		System.out.println("Selling " + businessToBeSold.name + " would give you $70,000");
		System.out.println("Would you like to proceed?");
		boolean validResponse = false;
		while (validResponse == false)
		{
			scan = new Scanner(System.in);
			String userDecision = scan.nextLine();
			if (userDecision.indexOf("Y") != -1 || userDecision.indexOf("y") != -1)
			{
				userBalance = userBalance + 70000.0;
				userBusinesses.remove(businessToBeSold);
				updateOwner();
				businessToBeSold = null;
				displayManageBusinessScreen();
				displayManageBusinessOptions();
				return;
			}
			else if (userDecision.indexOf("N") != -1 || userDecision.indexOf("n") != -1)
			{
				displayManageBusinessScreen();
				displayManageBusinessOptions();
				return;
				
			}
			else
			{
				System.out.println("Please type 'Yes' or 'No'");
			}
		}
	}
	
	//Should make a prettyPrint Function
	public void modifyBusiness(Business businessToBeModified)
	{
		scan = new Scanner(System.in);
		while(true)
		{
			System.out.println(businessToBeModified.name + "'s information:");
			System.out.println("Name: " +businessToBeModified.name +" | " + 
					"Open?: " + businessToBeModified.open + " | " + "Private?: " +
					businessToBeModified.getIsPrivate() + " | " + "Password: " + businessToBeModified.getPasscode());
			System.out.println("Select an aspect to modify, or if"
					+ " you would like to sell the Business type 'Sell'.");
			boolean isCasino = false;
			if (businessToBeModified instanceof Casino)
			{
				System.out.println("Since this is a Casino, you may also view your games by typing 'Games'.");
				isCasino = true;
			}
			String userDecision = scan.nextLine();
			if (userDecision.indexOf("sell") != -1 || userDecision.indexOf("Sell") != -1)
			{
				sellBusiness(businessToBeModified);
				return;
			}
			else if (userDecision.indexOf("Name") != -1 || userDecision.indexOf("name") != -1)
			{
				System.out.println("What would you like the new name to be?");
				scan = new Scanner(System.in);
				String newName = scan.nextLine();
				businessToBeModified.name = newName;
				updateOwner();
				displayManageBusinessScreen();
				displayManageBusinessOptions();
				return;
			}
			else if (userDecision.indexOf("Open") != -1 || userDecision.indexOf("open") != -1)
			{
				System.out.println("Set business to Open or Closed?");
				scan = new Scanner(System.in);
				boolean validResponse = false;
				while (validResponse == false)
				{
					String newOpeness = scan.nextLine();
					if (newOpeness.indexOf("Open") != -1 || newOpeness.indexOf("open") != -1)
					{
						businessToBeModified.open = true;
						updateOwner();
						displayManageBusinessScreen();
						displayManageBusinessOptions();
						return;
					}
					else if (newOpeness.indexOf("Closed") != -1 || newOpeness.indexOf("closed") != -1)
					{
						businessToBeModified.open = false;
						updateOwner();
						displayManageBusinessScreen();
						displayManageBusinessOptions();
						return;
					}
					else
					{
						System.out.println("Please type 'Open' or 'Closed'");
					}
				}
			}
			else if (userDecision.indexOf("Private") != -1 || userDecision.indexOf("private") != -1)
			{
				System.out.println("Set business to Public or Private?");
				scan = new Scanner(System.in);
				boolean validResponse = false;
				while (validResponse == false)
				{
					String newPrivacy = scan.nextLine();
					if (newPrivacy.indexOf("Private") != -1 || newPrivacy.indexOf("private") != -1)
					{
						businessToBeModified.setIsPrivate(true);
						System.out.println("Please provide a password for this business");
						String passcode = scan.nextLine();
						businessToBeModified.setPasscode(passcode);
						updateOwner();
						displayManageBusinessScreen();
						displayManageBusinessOptions();
						return;
					}
					else if (newPrivacy.indexOf("Public") != -1 || newPrivacy.indexOf("public") != -1)
					{
						businessToBeModified.setIsPrivate(false);
						businessToBeModified.setPasscode("");
						updateOwner();
						displayManageBusinessScreen();
						displayManageBusinessOptions();
						return;
					}
					else
					{
						System.out.println("Please type 'Private' or 'Public'");
					}
				}
			}
			else if (userDecision.indexOf("Password") != -1 || userDecision.indexOf("password") != -1)
			{
				businessToBeModified.setIsPrivate(true);
				System.out.println("Please provide a new password for this business");
				String passcode = scan.nextLine();
				businessToBeModified.setPasscode(passcode);
				updateOwner();
				displayManageBusinessScreen();
				displayManageBusinessOptions();
				return;
			}
			else if (userDecision.toLowerCase().indexOf("games") != -1 && isCasino == true)
			{
				Casino businessAsCasino = (Casino) businessToBeModified;
				displayGameScreen(businessAsCasino);
				return;
			}
			else
			{
				System.out.println("Please type 'Sell, 'Name', 'Open', 'Private', or 'Password'");
			}
			
		}
	}
	
	public void displayGameScreen(Casino usersCasino)
	{
		ArrayList<Game> gamesInCasino = usersCasino.getGamesInCasino();
		ArrayList<String> gameNames = new ArrayList<String>();
		for (int i = 0; i < gamesInCasino.size(); i = i + 1)
		{
			System.out.println(PrettyPrint.prettyPrintGame(gamesInCasino.get(i)));
			gameNames.add(gamesInCasino.get(i).name);
		}
		System.out.println("Would you like to buy a game, sell a game, or leave game menu?");
		scan = new Scanner(System.in);
		boolean validResponse = false;
		while (validResponse == false)
		{
			String response = scan.nextLine();
			if (response.toLowerCase().indexOf("sell") != -1)
			{
				System.out.println("Which game would you like to sell?");
				boolean validGameSelected = false;
				while (validGameSelected == false)
				{
					String selectedGame = scan.nextLine();
					if (gameNames.contains(selectedGame))
					{
						int gamePositionInList = gameNames.indexOf(selectedGame);
						sellGame(gamesInCasino.get(gamePositionInList));
						displayManageBusinessScreen();
						displayManageBusinessOptions();
						return;
					}
					else
					{
						System.out.println("Please select a game to sell by typing its name");
					}
				}
			}
			else if (response.toLowerCase().indexOf("buy") != -1)
			{
				Game newGame = addGameToCasino(usersCasino);
				gamesInCasino.add(newGame);
				usersCasino.updateCasino(gamesInCasino, usersCasino.getUsers(), usersCasino.income, usersCasino.loss);
				updateOwner();
				displayManageBusinessScreen();
				displayManageBusinessOptions();
				return;
			}
			else if (response.toLowerCase().indexOf("leave") != -1)
			{
				displayManageBusinessScreen();
				displayManageBusinessOptions();
				return;
			}
			else
			{
				System.out.println("Please type 'Buy', 'Sell', or 'Leave'");
			}
			
		}
		
	}
	
	public void sellGame(Game game)
	{
		Casino owningCasino = game.getOwningCasino();
		ArrayList<Game> updatedGames = game.getOwningCasino().getGamesInCasino();
		updatedGames.remove(game);
		owningCasino.updateCasino(updatedGames, owningCasino.getUsers(), owningCasino.income, owningCasino.loss);
		userBalance = userBalance + 5000.0;
		linkToOwner.updateOwner(userID, userBalance, userBusinesses);
		game = null;
	}
	
	/*
	 * pre-req: User has decided to buy a business
	 * 
	 * displays list of businesses to purchase
	 * asks user to enter the name of business
	 * 
	 * post: user is taken to respective business buying screen
	 */
	
	public void createBusiness()
	{
		System.out.println("Businesses Available: ");
		boolean validResponse = false;
		String businessToBeMade = "";
		while (validResponse == false)
		{
			for (int i = 0; i < businessesAvailableToPurchase.size(); i = i + 1)
			{
				System.out.println(businessesAvailableToPurchase.get(i));
			}
			System.out.println("What would you like to purchase?");
			scan = new Scanner(System.in);
			businessToBeMade = scan.nextLine();
			
			if (businessesAvailableToPurchase.indexOf(businessToBeMade) != -1)
			{
				validResponse = true;
			}
			else
			{
				System.out.println("Please type in one of the following businesses:");
			}
		}
		if (businessToBeMade.equals("Casino"))
		{
			createCasino();
		}
		
	}
	
	public int verifyOwnerFunds(double pendingAmount)
	{
		if ((userBalance - pendingAmount) <= 0.0)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	public void createCasino()
	{
		int userPaymentVerification = verifyOwnerFunds(10000.0);
		if (userPaymentVerification == -1)
		{
			System.out.println("Unfortunatly you do not have the required funds ($10,000) to purchase a casino");
			System.out.println("Your balance: " + userBalance);
			System.out.println("You may wait to see if your current businesses will profit, or you"
					+ " may sell a business in the edit menu. ");
			displayManageBusinessScreen();
			displayManageBusinessOptions();
			return;
			
		}
		System.out.println("It costs $100,000 to open a casino, you have " + userBalance
				+ " would you like to continue?");
		boolean validResponse = false;
		while (validResponse == false)
		{
			scan = new Scanner(System.in);
			String confirmation = scan.nextLine();
			if (confirmation.indexOf("Y") != -1 || confirmation.indexOf("y") != -1)
			{
				validResponse = true;
			}
			else if (confirmation.indexOf("N") != -1 || confirmation.indexOf("n") != -1)
			{
				validResponse = true;
				displayManageBusinessScreen();
				displayManageBusinessOptions();
				return;
				
			}
			else
			{
				System.out.println("Please type 'Yes' or 'No'");
			}
		}
		System.out.println("Please enter a unique name for this casino:");
		scan = new Scanner(System.in);
		String casinoName = scan.nextLine();
		Casino usersCasino = new Casino(casinoName, linkToOwner);
		userBalance = userBalance - 100000.0;
		System.out.println("Congratulations! You are now the proud owner of " + casinoName +"!");
		System.out.println("All casinos must have at least 1 game, so lets add one!");
		Game newGame = addGameToCasino(usersCasino);
		ArrayList<Game> currentGamesInCasino = usersCasino.getGamesInCasino();
		currentGamesInCasino.add(newGame);
		usersCasino.updateCasino(currentGamesInCasino, usersCasino.getUsers(), usersCasino.income, usersCasino.loss);
		userBusinesses.add(usersCasino);
		updateOwner();
		displayManageBusinessScreen();
		displayManageBusinessOptions();
		return;
	}
	
	public void printGameOptions()
	{
		System.out.println("There are 4 options for games:");
		System.out.println("Simple Game: A player bets any amount of money and "
				+ "we draw a card from a deck. "
				+ "If it is a face card they win 2.5x their bet. Cost: $10,000, 37% odds of winning.");
		System.out.println("Strict Bet Game: Same as Simple Game, but the bet must "
				+ "be between specified amounts. Player wins 2.1x their bet. Cost $15,000, 37% odds.");
		System.out.println("Fixed Bet Game: These are machine games. "
				+ "Anything from slots to machine poker. "
				+ "Bets are fixed, player wins 22x their bet. Cost $19,000 %3.7 odds." );
		System.out.println("Color Game: These are table games like Roulette. Player "
				+ "specifies a color, space, and bet. Player wins 1.6x their bet for correct color"
				+ "16x their money for correct number. And 37x their money for both."
				+ "Cost $24,000 %50, 5.2%, 2.6% odds." );
	}
	
	public Game addGameToCasino(Casino usersCasino)
	{
		scan = new Scanner(System.in);
		printGameOptions();
		boolean validResponse = false;
		
		while (validResponse == false)
		{
			System.out.println("Please type 'Simple', 'Strict', 'Fixed', or 'Color'");
			String gameSelection = scan.nextLine();
			if (gameSelection.toLowerCase().indexOf("simple") != -1)
			{
				userBalance = userBalance - 10000.0;
				updateOwner();
				return createSimpleGame(usersCasino);
			}
			else if (gameSelection.toLowerCase().indexOf("strict") != -1)
			{
				userBalance = userBalance - 15000.0;
				updateOwner();
				return createStrictGame(usersCasino);
				
			}
			else if (gameSelection.toLowerCase().indexOf("fixed") != -1)
			{
				userBalance = userBalance - 19000.0;
				updateOwner();
				return createFixedGame(usersCasino);
			}
			else if (gameSelection.toLowerCase().indexOf("color") != -1)
			{
				userBalance = userBalance - 24000.0;
				updateOwner();
				return createColorGame(usersCasino);
			}
			
		}
		return null;
		
	}
	
	public Game createSimpleGame(Casino usersCasino)
	{
		scan = new Scanner(System.in);
		System.out.print("To buy a Simple Game you must give it a unique name (i.e. MagicMoney1):");
		String name  = scan.nextLine();
		SimpleGame newGame = new SimpleGame(usersCasino, name);
		return newGame;
	}
	
	public Game createStrictGame(Casino usersCasino)
	{
		scan = new Scanner(System.in);
		System.out.print("To buy a Strict Game you must give it a unique name (i.e. MagicMoney1):");
		String name  = scan.nextLine();
		System.out.println("You must also provdide a minimum bet amount:");
		boolean validResponse = false;
		double min = 0.0;
		while (validResponse == false)
		{
			String minBet  = scan.nextLine();
			try
			{
			  min = Double.parseDouble(minBet);
			  if (min > 0.0)
			  {
				  validResponse = true;
			  }
			}
			catch(NumberFormatException e)
			{
			  System.out.println("Please specify a number greater than 0");
			}
		}
		System.out.println("You must also provdide a maxium bet amount:");
		boolean validResponse2 = false;
		double max = 0.0;
		while (validResponse2 == false)
		{
			String maxBet  = scan.nextLine();
			try
			{
			  max = Double.parseDouble(maxBet);
			  if (max > min)
			  {
				  validResponse2 = true;
			  }
			}
			catch(NumberFormatException e)
			{
			  System.out.println("Please specify a number greater than " + min);
			}
		}
		DynamicBetDecorator newGame = new DynamicBetDecorator(usersCasino, name, min, max);
		return newGame;
	}
	
	public Game createFixedGame(Casino usersCasino)
	{
		scan = new Scanner(System.in);
		System.out.print("To buy a Fixed Bet Game you must give it a unique name (i.e. MagicMoney1):");
		String name  = scan.nextLine();
		System.out.println("You must also provdide a fixed bet amount:");
		boolean validResponse = false;
		double fixedBet = 0.0;
		while (validResponse == false)
		{
			String fixedBetInput  = scan.nextLine();
			try
			{
			  fixedBet = Double.parseDouble(fixedBetInput);
			  if (fixedBet > 0.0)
			  {
				  validResponse = true;
			  }
			}
			catch(NumberFormatException e)
			{
			  System.out.println("Please specify a number greater than 0");
			}
		}
		FixedBetDecorator newGame = new FixedBetDecorator(usersCasino, name, fixedBet);
		return newGame;
	}
	
	public Game createColorGame(Casino usersCasino)
	{
		scan = new Scanner(System.in);
		System.out.print("To buy a Color Game you must give it a unique name (i.e. MagicMoney1):");
		String name  = scan.nextLine();
		ColorGameDecorator newGame = new ColorGameDecorator(usersCasino, name);
		return newGame;
	}
	
}
