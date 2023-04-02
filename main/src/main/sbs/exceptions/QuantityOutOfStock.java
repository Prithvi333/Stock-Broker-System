package main.sbs.exceptions;

@SuppressWarnings("serial")
public class QuantityOutOfStock extends Exception {

	public QuantityOutOfStock() {
		
	}
	public QuantityOutOfStock(String msg) {
		super(msg);
	}
}
