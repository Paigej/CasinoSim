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

	public ArrayList<String> businesses;
	


	Owner(String username, String password, double balance) {
		super(username, password, balance);
		this.businesses = new ArrayList<String>();
	}

	// change to private
	//public void removeUser(String user) {
	//}

	// Implement game first
	// change to private
	//public void buyBusiness(String busType, String busName){
	//}

	// Implement game first
	// change to private
	//public void sellBusiness(String busType, String busName){
	//}

	public String getBusinessID() {
		return activeBusinessID;
	}

	// TODO: figure out where to find the business object, only passing in the ID
	//public void toggleOpenClose(String businessID) {
	//	businessID.changeOpenStatus();
	//}
}