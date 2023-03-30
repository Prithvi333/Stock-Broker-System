package main.sbs.exceptions;

@SuppressWarnings("serial")
public class DuplicateCustomer extends Exception {

	public DuplicateCustomer() {

	}

	public DuplicateCustomer(String msg) {
		super(msg);
	}

}
