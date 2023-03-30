package main.sbs.exceptions;

@SuppressWarnings("serial")
public class InvalidCredentials extends Exception {

	public InvalidCredentials() {
		
	}
	public InvalidCredentials(String msg) {
     super(msg);		
	}
      
}
