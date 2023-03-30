package main.sbs.services;

import java.time.LocalDate;
import java.util.*;
import main.sbs.entity.*;
import main.sbs.exceptions.*;


public class CustomerServiceImp implements CustomerService {

	@Override
	public boolean signUp(Customer cst, Map<String, Customer> cus) throws DuplicateCustomer {
		// TODO Auto-generated method stub
		if(!cus.containsKey(cst.getEmail())) {
			cus.put(cst.getEmail(),cst );
			return true;
		}
		else throw new DuplicateCustomer("Customer account is already registered");
	
	}

	@Override
	public boolean signIn(String email,String password, Map<String, Customer> cus) throws InvalidCredentials {
		// TODO Auto-generated method stub
		if(cus.get(email).getEmail().equals(email)) {
			if(cus.get(email).getPassWord().equals(password));
			return true;
		}
		else {
			System.out.println("Please enter the valid email");
		}
		return false;
	}

	@Override
	public String buyStocks(String user, String email, String stockName, int quantity, Map<String, Stock> stock,
			Map<String, Customer> customer, List<Transaction> transaction) throws QuantityOutOfStock {
		// TODO Auto-generated method stub
		if(stock.size()!=0) {
			if(stock.containsKey(stockName)) {
				
				if(quantity<=stock.get(stockName).getQuantity()) {
                    double cu=customer.get(email).getWalletBalance();
					double price=quantity*stock.get(stockName).getCurrentPrice();
                    
					if(cu>=price) {
						Customer ct=customer.get(email);
						ct.setstockQuantity(quantity);
						ct.setWalletBalance(cu-price);
						customer.put(email, ct);
						Stock st=stock.get(stockName);
						st.setQuantity(st.getQuantity()-quantity);
						
						Transaction ts=new Transaction(user, email, stockName, stock.get(stockName).getCurrentPrice(), quantity, price, LocalDate.now());
						transaction.add(ts);
					}
					
					
				}
				else throw new QuantityOutOfStock("Quantity is out of limit");
			}
			else {
				return "Stock of this name is not available";
			}
		}
		else {
			return "Stock is not available to buy";
		}
		return "You bought stock successfully";
	}

	@Override
	public double viewWalletBalance(String email, Map<String, Customer> customer) throws InvalidEmail {
		// TODO Auto-generated method stub
		if(customer.containsKey(email)) {
			return customer.get(email).getWalletBalance();
		}
		else throw new InvalidEmail("Email is not valid");
	}

	@Override
	public String addWalletMoney(String email,double amount, Map<String, Customer> customer) throws InvalidEmail {
		// TODO Auto-generated method stub
		if(customer.containsKey(email)) {
		 customer.get(email).setWalletBalance(customer.get(email).getWalletBalance()+amount);
		}
		else throw new InvalidEmail("Email is not valid");
		return "Money is added successfully in your wallet!";
	}

	@Override
	public Customer viewMyDetails(String email, Map<String, Customer> customer) throws InvalidEmail {
		// TODO Auto-generated method stub
		if(customer.containsKey(email)) {
			 return customer.get(email);
			}
			else throw new InvalidEmail("Email is not valid");
	}

	@Override
	public List<Transaction> viewMyTransactions(String email, List<Transaction> transaction) {
		// TODO Auto-generated method stub
		
		List<Transaction>lv=null; 
		boolean flag=false;
		if(!transaction.isEmpty()) {
			lv=new ArrayList<>();
		for(Transaction tr:transaction) {
			if(tr.getEmail().equals(email)) {
				lv.add(tr);
				flag=true;
			} 
		}
		}
		if(!flag) System.out.println("No transactions yet");
		
		return lv;
	}

	@Override
	public String sellStocks(String user, String email, String stockName, int quantity, Map<String, Stock> stock,
			Map<String, Customer> customer, List<Transaction> transaction) {
		// TODO Auto-generated method stub
		if(customer.containsKey(email)) {
			
			if(stock.containsKey(stockName)) {
				Customer cs=customer.get(email);
				if(quantity<=cs.getstockQuantity()) {
					 double amount=quantity*stock.get(stockName).getCurrentPrice();
					 cs.setWalletBalance(cs.getWalletBalance()+amount);
					 cs.setstockQuantity(cs.getstockQuantity()-quantity);
					 customer.put(email, cs);
				}
				else System.out.println("You dont have sufficient quantity of stocks");
			}
			else {
				System.out.println("Stock with this name is not available");
			}
		}
			
		else {
			System.out.println("Please enter valid email id");
		}
		return null;
	}

	
}
