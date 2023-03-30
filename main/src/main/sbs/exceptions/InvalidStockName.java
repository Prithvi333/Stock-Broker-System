package main.sbs.exceptions;

@SuppressWarnings("serial")
public class InvalidStockName extends Exception {

	public InvalidStockName() {
		
	}
	public InvalidStockName(String msg) {
		super(msg);
	}
}
