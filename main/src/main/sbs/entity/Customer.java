package main.sbs.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer extends User implements Serializable {
	double walletBalance;
	int stockQuantity = 0;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String userName, String passWord, String email, long mob,
			String address, String status, double walletBalance) {
		super(firstName, lastName, userName, passWord, email, mob, address, status);
		this.walletBalance = walletBalance;
	}

	public void setStatus(String val) {
		status = val;
	}

	public String getStatus() {
		return status;
	}

	public void setstockQuantity(int quant) {
		stockQuantity = quant;
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
				+ ", WalletBalance- " + walletBalance + " Status- " + status;
	}
}
