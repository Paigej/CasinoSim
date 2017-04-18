/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac Casino.java
 *  
 *  Implements the Business class, the foundation to the casino structure.
 *
 ******************************************************************************/

import java.util.*;

public class Casino extends Business {
	private ArrayList<String> gameIDList;
	private ArrayList<String> users;
	private String ownerID;

	public double income;
	public double loss;

	// Insert constructor here

	public ArrayList<String> getUserList() {
		return users;
	}

	// change to private
	public void removeUser(String user) {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(user);
		users.removeAll(temp);
	}

	// Need to write game class for this function
	//public Game addGame(String gameType, double maxBet, double minBet) {
	//}

	// change to private
	public void removeGame(String gameID) {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(gameID);
		gameIDList.removeAll(temp);
		// Needs update owner balance code
		// Need controls for kicking out users
	}
}