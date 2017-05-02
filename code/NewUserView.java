/******************************************************************************
 *  Author(s):    Michael Condon
 *
 *  Compilation:  javac newUserView.java
 *  
 *  Initial view for a user that has not yet been recognized
 *
 ******************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class NewUserView {

	//Object used to get input from user (Command Line UI)
	private static Scanner scan;
	
	static ArrayList<Owner> Owners = new ArrayList<Owner>();
	static ArrayList<String> ownerNames = new ArrayList<String>();
	static ArrayList<Player> Players = new ArrayList<Player>();
	static ArrayList<String> playerNames = new ArrayList<String>();

	static Map<String, String> userLogins = new HashMap<String, String>();
	


	
	
	
	NewUserView()
	{
		Owner paigeAsAnOwner = new Owner ("PaigeO", "password", "paigeSecretlyLikes50Cent@aol.com");
		Casino flamingo = new Casino("Flamingo", paigeAsAnOwner);
		ColorGameDecorator roulette = new ColorGameDecorator(flamingo, "Roulette");
		ArrayList<Game> flamingoGames = new ArrayList<Game>();
		flamingoGames.add(roulette);
		flamingo.setGamesInCasino(flamingoGames);
		ArrayList<Business> paigesBusinesses = new ArrayList<Business>();
		paigesBusinesses.add(flamingo);
		paigeAsAnOwner.setBusinesses(paigesBusinesses);
		ownerNames.add(paigeAsAnOwner.username);

		
		Player paigeAsAPlayer = new Player("PaigeP", "password", "paigeSecretlyLikes50Cent@aol.com");
		Owners.add(paigeAsAnOwner);
		Players.add(paigeAsAPlayer);
		userLogins.put(paigeAsAnOwner.username, paigeAsAnOwner.getPassword());
		userLogins.put(paigeAsAPlayer.username, paigeAsAPlayer.getPassword());
		playerNames.add(paigeAsAPlayer.username);
	}



	/*
	 * Initial message to user
	 */
	public static void printIntroMessage(){
		System.out.println("Welcome to CasinoSim!");
		System.out.println("Log in or Sign up?");
	}

	/*
	 * Pre-req: NA 
	 * 
	 * Allows user to select whether they are signing up or logging in
	 * will repeat until user has chosen a valid option
	 * returns a number indicating user's selection
	 * 1 for log in screen
	 * 2 for sign up
	 * 
	 * Post: User is taken to respective credentials prompt (through main)
	 */
	public static int choseLogIn(){
		scan = new Scanner(System.in);
		String userSelection = scan.nextLine();// Scans the next token of the input as a String.
		
		if (userSelection.indexOf("Log") != -1 || userSelection.indexOf("log") != -1)
		{
			return 1;
		}
		else if (userSelection.indexOf("Sign") != -1 || userSelection.indexOf("sign") != -1)
		{
			return 2;
		}
		else if (userSelection.toLowerCase().equals("exit"))
		{
		    System.exit(0);
		    return -1;
		}
		else
		{
			System.out.println("Please type 'Log in' or 'Sign up'");
			return choseLogIn();
		}
	}
	
	/*
	 * Pre-req: User has chosen to create a new account
	 * 
	 * Allows user to define whether they are a Casino Owner or Player
	 * Will recursively repeat until there is a valid response (Stack overflow attack not protected)
	 * 
	 * Post: Controller now knows what type of user to create
	 */
	public static int choseUserType(){
		scan = new Scanner(System.in);
		String userSelection = scan.nextLine();// Scans the next token of the input as a String.
		
		if (userSelection.indexOf("Owner") != -1 || userSelection.indexOf("owner") != -1)
		{
			return 1;
		}
		else if (userSelection.indexOf("Player") != -1 || userSelection.indexOf("player") != -1)
		{
			return 2;
		}
		else
		{
			System.out.println("Please type 'Owner' or 'Player'");
			return choseUserType();
		}
	}
	
	/*
	 * Pre-req: User is not yet defined in system, and user has chosen to log in
	 * 
	 * Gathers required log in info from user to log in
	 * Will recursively repeat until valid response
	 * 
	 * post: Player is brought to respective View
	 */
	
	public static void getLogInInfo(){
		System.out.print("Username: ");
		scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.print("Password: ");
		scan = new Scanner(System.in);
		String password = scan.nextLine();
		if (verifyLogin(username, password) > 0)
		{
			if (ownerNames.contains(username))
			{
			OwnerView ownersScreen = new OwnerView(Owners.get(ownerNames.indexOf(username)));
			ownersScreen.displayManageBusinessScreen();
			ownersScreen.displayManageBusinessOptions();
			}
			else
			{
				PlayerView PlayersScreen = new PlayerView(Players.get(playerNames.indexOf(username)));
				PlayersScreen.displayMainPlayerScreen();
			}
		}
		else
		{
			System.out.println("Log in unsuccessful");
			getLogInInfo();
		}

	}
	
	//Need to figure out the database stuff for this function 
	public static int verifyLogin(String username, String password)
	{
		String isPresent = userLogins.get(username);
		if (isPresent != null) 
		{
		    if (isPresent.equals(password))
		    {
		    	return 1;
		    }
		    else
		    {
		    	System.out.println("Invalid Password");
		    	return -1;
		    }
		} 
		else 
		{
			System.out.println("Invalid Username");
			return -1;
		}
	}
	
	

	/*
	 * Pre-req: User has chosen to sign up in choseLogIn()
	 * 
	 * Gathers info from User that is required for a new account to be created
	 * Recursively repeats until valid info
	 * Returns the instance of User created
	 * 
	 * Post: createOwner() or createPlayer() is called
	 */
	public static User signUp(){
		System.out.print("Email: ");
		scan = new Scanner(System.in);
		String userEmail = scan.nextLine();
		System.out.print("Username: ");
		scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.print("Password: ");
		scan = new Scanner(System.in);
		String password = scan.nextLine();
		System.out.print("Confirm Password: ");
		scan = new Scanner(System.in);
		String confirmedPassword = scan.nextLine();
		if (confirmedPassword.equals(password))
		{
			System.out.println("Would you like to play as an Owner or Player?");
			if (choseUserType() == 1)
			{
				Owner newOwner = new Owner(username, password, userEmail);
				return newOwner;
			}
			else 
			{
				Player newPlayer = new Player(username, password, userEmail);
				return newPlayer;
			}

		}
		else
		{
			System.out.println("Passwords do not match. Try again.");
			return signUp();
		}

	}
	
	/*
	 * 
	 * You can think of this as the "main" of the NewUserView
	 * 
	 */
	
	public void displayView() 
	{
		printIntroMessage();
		int loginOrSignup = choseLogIn();
		if (loginOrSignup == 1)
		{
			getLogInInfo();
			displayView();
		}
		else if (loginOrSignup == 2)
		{
			User newUser = signUp();
			if (newUser instanceof Owner)
			{
				Owner newUserAsOwner = (Owner) newUser;
				OwnerView ownersScreen = new OwnerView(newUserAsOwner);
				ownersScreen.displayManageBusinessScreen();
				ownersScreen.displayManageBusinessOptions();
				displayView();
			}
			else if (newUser instanceof Player)
			{
				Player newUserAsPlayer = (Player) newUser;
				PlayerView PlayersScreen = new PlayerView(newUserAsPlayer);
				PlayersScreen.displayMainPlayerScreen();
				displayView();
			}
		}
		else 
		{
			return;
		}
	}

}


