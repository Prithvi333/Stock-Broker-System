package main.sbs.entity;

public class Customer extends User {
	double walletBalance = 0;
	
	public Customer() {
		
	}
	
	public Customer(String userName, String passWord, String email, String address, double walletBalance) {
		super(userName, passWord, email, address);
		this.walletBalance = walletBalance;
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
