/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
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
	private Owner ownerID;

	public String name;
	public boolean open;

	public double income;
	public double loss;
	
	Business(String _name, Owner _ownerID) {
		this.name = _name;
		this.open = true;
		this.IsPrivate = false;
		this.passcode = "";
		this.id = 2;
		this.setOwner(_ownerID);
		this.income = 0.0;
		this.loss = 0.0;
	}

	public void setIsPrivate(boolean isPrivate) {
		IsPrivate = isPrivate;
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

	public Owner getOwnerID() {
		return ownerID;
	}

	public void setOwner(Owner ownerID) {
		this.ownerID = ownerID;
	}

	public double getNetGain() {
		return income - loss;
	}

	
	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
}
