/******************************************************************************
 *  Author(s):    Derek Gorthy
 *
 *  Compilation:  javac Business.java
 *  Execution:    java Business
 *  
 *  Implements the Business class, the foundation to the casino structure.
 *
 ******************************************************************************/

public class Business {
	private int id;
	private String passcode;

	public String name;
	public boolean open;
	public boolean IsPrivate;

	Business(String name) {
		this.name = name;
		this.open = true;
		this.IsPrivate = false;
		this.passcode = "";
		this.id = 2;
	}

	public int getId() {
		return id;
	}

    public static void main(String[] args) {
        Business myCasino = new Business("Flamingo");
        System.out.println(myCasino.name);
    }

}
