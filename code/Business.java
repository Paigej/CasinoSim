/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac Business.java
 *  
 *  Implements the Business class, the foundation to the casino structure.
 *
 ******************************************************************************/

public abstract class Business {
	private int id;
	private String passcode;
	private boolean IsPrivate;
	private String ownerID;

	public String name;
	public boolean open;

	Business(String name, String ownerID) {
		this.name = name;
		this.open = true;
		this.IsPrivate = false;
		this.passcode = "";
		this.id = 2;
	}

	public boolean getIsPrivate() {
		return IsPrivate;
	}

	public int getId() {
		return id;
	}

	public void changeIsPrivate() {
		IsPrivate = !IsPrivate;
	}

	public void changeOpenStatus() {
		open = !open;
	}

	public void addPasscode(String str) {
		passcode = str;
	}

	public boolean validatePasscode(String givenPasscode) {
		return (givenPasscode == passcode);
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
}
