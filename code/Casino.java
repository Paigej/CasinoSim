/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac Casino.java
 *  
 *  Implements the Business class, the foundation to the casino structure.
 *
 ******************************************************************************/

import java.util.*;

public class Casino extends Business {
	private ArrayList<Game> gamesInCasino;
	private ArrayList<User> users;
	private ArrayList<String> userNames;

	public double income;
	public double loss;

	// Insert constructor here

	Casino(String name, String ownerID) {
		super(name, ownerID);
		this.setGamesInCasino(new ArrayList<Game>());
		this.users = new ArrayList<User>();
		this.income = 0.0;
		this.loss = 0.0;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
		userNames.clear();
		for (User i: users)
		{
			userNames.add(i.username);
		}
	}
	
	public void removeUser(String user) 
	{
		int positionOfUserInList = userNames.indexOf(user);
		users.remove(positionOfUserInList);
		setUsers(users);
	}
	
	public void updateCasino(ArrayList<Game> _gamesInCasino, ArrayList<User> _users, 
			double _income, double _loss)
	{
		this.setGamesInCasino(_gamesInCasino);
		this.setUsers(_users);
		this.income = _income;
		this.loss = _loss;
	}

	public ArrayList<Game> getGamesInCasino() {
		return gamesInCasino;
	}

	public void setGamesInCasino(ArrayList<Game> gamesInCasino) {
		this.gamesInCasino = gamesInCasino;
	}


}