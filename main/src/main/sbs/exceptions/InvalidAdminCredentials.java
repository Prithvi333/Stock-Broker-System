package main.sbs.exceptions;

@SuppressWarnings("serial")
public class InvalidAdminCredentials extends Exception {

	public InvalidAdminCredentials() {
		
	}
	public InvalidAdminCredentials(String msg) {
		super(msg);
	}
}
