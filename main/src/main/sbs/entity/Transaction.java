package main.sbs.entity;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Transaction implements Serializable {

	String UserName;
	String eMail;
	String stockName;
	double stockPrice;
	int stockQuantity;
	double total;
	String transactionType;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	LocalDate ld;

	public Transaction() {

	}

	public Transaction(String UserName, String eMail, String stockName, double stockPrize, int stockQuantity,
			double total, LocalDate ld) {
		this.UserName = UserName;
		this.eMail = eMail;
		this.stockName = stockName;
		this.stockPrice = stockPrize;
		this.stockQuantity = stockQuantity;
		this.total = total;
		this.ld = ld;
	}

	public void setUserName(String name) {
		this.UserName = name;
	}

	public String getUserName() {
		return UserName;
	}

	public void setEmail(String mail) {
		this.eMail = mail;
	}

	public String getEmail() {
		return eMail;
	}

	public void setStockName(String name) {
		this.stockName = name;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockPrize(int prize) {
		this.stockPrice = prize;
	}

	public double getStockPrize() {
		return this.stockPrice;
	}

	public void setStockQuantity(int quant) {
		this.stockQuantity = quant;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setTotal(double amount) {
		this.total = amount;
	}

	public double getTotal() {
		return total;
	}

	public void setDate(LocalDate value) {
		this.ld = value;
	}

	public LocalDate getDate() {
		return ld;
	}

	public String toString() {
		return "UserName- " + UserName + ", Email- " + eMail + ", StockName- " + stockName + ", StockPrize- "
				+ stockPrice + ", StockQuantity- " + stockQuantity + ", Total- " + total + ", TransactonType- "
				+ transactionType + ", Date- " + ld;
	}
}
