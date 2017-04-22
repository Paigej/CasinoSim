import java.util.Scanner;

/******************************************************************************
 *  Author(s):    Michael Condon
 *
 *  Compilation:  javac MainController.java
 *  
 *  The primary driver for the CasinoSimulator
 *
 ******************************************************************************/
public class MainController {
	
	private static Scanner scan;

	/*
	 * Intial message to user
	 */
	public static void printIntroMessage(){
		System.out.println("Welcome to CasinoSim!");
		System.out.println("Log in or Sign up?");
	}

	/*
	 * Allows user to select whether they are signing up or logging in
	 * will repeat until user has chosen a valid option
	 * returns a number indicating user's selection
	 * 1 for log in screen
	 * 2 for sign up
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
		else
		{
			System.out.println("Please type 'Log in' or 'Sign up'");
			return choseLogIn();
		}
	}
	
	public static void getLogInInfo(){
		System.out.print("Username: ");
		scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.print("Password: ");
		scan = new Scanner(System.in);
		String password = scan.nextLine();
		if (verifyLogin(username, password) > 0)
		{
			System.out.println("Log in successful");
		}
		else
		{
			System.out.println("Log in unsuccessful");
			getLogInInfo();
		}

	}
	
	//Need to figure out the database stuff for this function 
	public static int verifyLogin(String username, String password){
		/*
		 * 
		 *Database verification here
		 */
		return 1;
	}

	public static void signUp(){
		System.out.print("Username: ");
		scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.print("Password: ");
		scan = new Scanner(System.in);
		String password = scan.nextLine();

	}
	
	public static void main(String[] args) {
		printIntroMessage();
		int nextView = choseLogIn();
		if (nextView == 1)
		{
			getLogInInfo();
		}
		else if (nextView == 2)
		{
			signUp();
		}
		
	}

}
