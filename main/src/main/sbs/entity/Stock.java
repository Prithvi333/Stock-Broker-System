package main.sbs.entity;

public class Stock {

	String Name;
	double currentPrice;
	 int quantity = 500;

	public Stock() {
		
	}
	
	public Stock(String companyName, double currentPrice) {
		this.Name = companyName;
		this.currentPrice = currentPrice;
	}

	public void setQuantity(int qt) {
		this.quantity=qt;
	}
	public int getQuantity() {
		return quantity;
	}
	public void SetName(String name) {
		this.Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setCurrentPrice(double price) {
		this.currentPrice = price;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}


	public String toString() {
		return "Name- " + Name + ", CurrentPrice- " + currentPrice + ", Quantity- " + quantity;
	}
}
