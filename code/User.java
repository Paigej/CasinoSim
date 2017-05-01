/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
 *
 *  Compilation:  javac User.java
 *  
 *  Base class for users of system.
 *
 ******************************************************************************/

public abstract class User {
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	private double balance;
	public String username;
	public void setBalance(double balance) {
		this.balance = balance;
	}

	private String email;

	User(String username, String password, double balance, String email) {
		this.password = password;
		this.username = username;
		this.balance = balance;
		this.setEmail(email);
	}


	public double getBalance() {
		return balance;
	}
	
	public void increaseBalance(double profit)
	{
		balance = balance + profit;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean validatePassword(String password_entered) {
		return (password == password_entered);
	}

	public boolean positiveBalance() {
		return (balance >= 0.0);
	}

	public void updateBalance(double addOrSub) {
		balance += addOrSub;
	}
}
