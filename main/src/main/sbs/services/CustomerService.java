package main.sbs.services;

import java.util.*;
import main.sbs.entity.*;
import main.sbs.exceptions.*;

public interface CustomerService {

	boolean signUp(Customer cst, Map<String, Customer> cus) throws DuplicateCustomer;

	boolean signIn(String email,String password, Map<String, Customer> cus) throws InvalidCredentials;

	String buyStocks(String user, String email, String stockName, int quantity, Map<String, Stock> stock,
			Map<String, Customer> customer, List<Transaction> transaction,List<Customer>cs) throws QuantityOutOfStock;
	
	String sellStocks(String user, String email, String stockName, int quantity, Map<String, Stock> stock,
			Map<String, Customer> customer, List<Transaction> transaction);

	double viewWalletBalance(String email, Map<String, Customer> customer) throws InvalidEmail;
	
	String addWalletMoney(String email,double amount, Map<String, Customer> customer,List<Customer>cus) throws InvalidEmail;

	void withdrawMoney(String email,String  password,double amount,Map<String,Customer>customer,List<Transaction>tr);
	
	Customer viewMyDetails(String email, Map<String, Customer> customer) throws InvalidEmail;

	List<Transaction> viewMyTransactions(String email, List<Transaction> transaction) ;

}
