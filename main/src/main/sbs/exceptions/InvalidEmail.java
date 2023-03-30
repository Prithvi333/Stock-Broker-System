package main.sbs.exceptions;

@SuppressWarnings("serial")
public class InvalidEmail extends Exception {

	public InvalidEmail() {
		
	}
	public InvalidEmail(String msg) {
		super(msg);
	}
}
