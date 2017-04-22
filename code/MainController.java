/******************************************************************************
 *  Author(s):    Michael Condon
 *
 *  Compilation:  javac MainController.java
 *  
 *  The primary driver for the CasinoSimulator
 *
 ******************************************************************************/
public class MainController {

	public static void main(String[] args) {
		
		Owner Bob = new Owner("Bob", "bob1978", 10000);
		System.out.println(Bob.getBalance());
	}

}
