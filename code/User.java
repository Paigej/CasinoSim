/******************************************************************************
 *  Author(s):    Derek Gorthy, Michael Condon
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
