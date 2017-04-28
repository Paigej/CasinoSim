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

	/*
	 * Since this is a view class it receives info about the user it is displaying to
	 * so the constructor below takes in an Owner object
	 */
	OwnerView(Owner ownerInfo)  
	{
		this.userID = ownerInfo.username;
		this.userBalance = ownerInfo.getBalance();
		this.userBusinesses = ownerInfo.getBusinesses();
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
			System.out.println("Please type the name of the business:");
		}
		else if (userSelection.indexOf("Buy") != -1 || userSelection.indexOf("buy") != -1)
		{
			System.out.println("Enter in business info");
		}
		else
		{
			System.out.println("Please type 'Edit' or 'Buy'");
			displayManageBusinessOptions();
		}
	}
	
}
