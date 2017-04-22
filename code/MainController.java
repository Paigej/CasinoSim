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
	
	public static void logIn(){
		
	}

	public static void signUp(){
		
	}
	
	public static void main(String[] args) {
		printIntroMessage();
		int nextView = choseLogIn();
		if (nextView == 1)
		{
			logIn();
		}
		else if (nextView == 2)
		{
			signUp();
		}
		
	}

}
