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

	/*
	 * Since this is a view class it receives info about the user it is displaying to
	 * so the constructor below takes in an Owner object
	 */
	OwnerView(Owner ownerInfo)  
	{
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
		}
		else if (userSelection.indexOf("Buy") != -1 || userSelection.indexOf("buy") != -1)
		{
			createBusiness();
		}
		else
		{
			System.out.println("Please type 'Edit' or 'Buy'");
			displayManageBusinessOptions();
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
			for(int i = 0; i < userBusinesses.size(); i = i + 1) 
			{
				System.out.println(userBusinesses.get(i).name +" | " + 
						userBusinesses.get(i).getClass() + " | " + userBusinesses.get(i).getNetGain()
						+ " | " + userBusinesses.get(i).open + " | " +
						userBusinesses.get(i).getIsPrivate() + " | " + userBusinesses.get(i).getPasscode());
			}
			scan = new Scanner(System.in);
			String businessToBeEdited = scan.nextLine();
			System.out.println(businessToBeEdited);
		}
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
		while (validResponse == false)
		{
			for (int i = 0; i < businessesAvailableToPurchase.size(); i = i + 1)
			{
				System.out.println(businessesAvailableToPurchase.get(i));
			}
			System.out.println("What would you like to purchase?");
			scan = new Scanner(System.in);
			String businessToBeMade = scan.nextLine();
			
			if (businessesAvailableToPurchase.indexOf(businessToBeMade) != -1)
			{
				System.out.println(businessToBeMade + " selected");
				validResponse = true;
			}
			else
			{
				System.out.println("Please type in one of the following businesses:");
			}
		}
		
	}
	
}
