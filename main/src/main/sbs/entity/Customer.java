package main.sbs.entity;

public class Customer extends User {
	double walletBalance = 0;
	int stockQuantity=0;
	public Customer() {
		
	}
	
	public Customer(String firstName,String lastName,String userName, String passWord, String email,long mob, String address, double walletBalance) {
		super(firstName,lastName,userName, passWord, email,mob, address);
		this.walletBalance = walletBalance;
	}

	public void setstockQuantity(int quant) {
		stockQuantity=quant;
	}
	public int getstockQuantity() {
		return stockQuantity;
	}
	public void setWalletBalance(double amount) {
		this.walletBalance = amount;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public String toString() {
		return "UserName- " + userName + ", Password- " + passWord + ", Email- " + email + ", Address- " + address
				+ ", WalletBalance- " + walletBalance;
	}
}
