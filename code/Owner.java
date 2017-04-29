/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac Owner.java
 *  
 *  Implements the Owner class.
 *
 ******************************************************************************/

import java.util.*;

public class Owner extends User {
	private String activeBusinessID;

	public ArrayList<Business> businesses;
	


	Owner(String username, String password, String email) {
		super(username, password, 500000.0, email);
		this.businesses = new ArrayList<Business>();
	}
	
	public void updateOwner(String userID, double userBalance, ArrayList<Business> userBusinesses)
	{
		this.username = userID;
		this.updateBalance(userBalance);
		this.setBusinesses(userBusinesses);
	}

	
	public ArrayList<Business> getBusinesses() {
		return businesses;
	}



	public void setBusinesses(ArrayList<Business> businesses) {
		this.businesses = businesses;
	}



	public String getBusinessID() {
		return activeBusinessID;
	}

}