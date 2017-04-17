/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac Business.java
 *  Execution:    java Business
 *  
 *  Implements the Business class, the foundation to the casino structure.
 *
 ******************************************************************************/

public abstract class Business {
	private int id;
	private String passcode;
	private boolean IsPrivate;

	public String name;
	public boolean open;

	Business(String name) {
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

	public void addPasscode(String str) {
		passcode = str;
	}

	public boolean validatePasscode(String givenPasscode) {
		return (givenPasscode == passcode);
	}
}
