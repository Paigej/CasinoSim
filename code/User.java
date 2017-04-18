/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac User.java
 *  
 *  Base class for users of system.
 *
 ******************************************************************************/

public abstract class User {
	private String password;
	private double balance;

	public String username;

	User(String username, String password, double balance) {
		this.password = password;
		this.username = username;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public String validatePassword(String password_entered) {
		return (password == password_entered);
	}

	public boolean positiveBalance() {
		return (balance >= 0.0);
	}

	public void updateBalance(double addOrSub) {
		balance += addOrSub;
	}
}
