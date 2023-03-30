package main.sbs.services;

import java.util.*;

import main.sbs.entity.Customer;
import main.sbs.entity.Stock;
import main.sbs.exceptions.InvalidStockName;

public class StockServiceImp implements StockService{

	@Override
	public String addStock(Stock st, Map<String, Stock> stock) {
		// TODO Auto-generated method stub
		if(!stock.containsKey(st.getName())){
			stock.put(st.getName(), st);
		}
		else return "Stock with given name is already present";
		return "Stock added successfully!";
	}

	@Override
	public String deleteStock(String stockName, Map<String, Stock> stock) throws InvalidStockName {
		// TODO Auto-generated method stub
		if(stock.containsKey(stockName)) {
			stock.remove(stockName);
		}
		else throw new  InvalidStockName("Stock with given name is not present");
		return "Stock deleted successfully";
	}

	@Override
	public String UpdateStock(Stock stoc, Map<String, Stock> stock) throws InvalidStockName {
		// TODO Auto-generated method stub
		if(stock.containsKey(stoc.getName())){
		 stock.put(stoc.getName(), stoc);
		}
		
		else throw new  InvalidStockName("This stock is not present to update");
		return "Stock updated!";
	}

	@Override
	public List<Stock> viewStocks(Map<String, Stock> stock) {
		// TODO Auto-generated method stub
		List<Stock>st=null;
		if(!stock.isEmpty()) {
			st=new ArrayList<>();
			Collection<Stock>cv=stock.values();
			for(Stock val:cv) st.add(val);
		}
		return st;
	}

	@Override
	public List<Customer> viewAllCustomer(Map<String, Customer> customer) {
		
		List<Customer>st=null;
		if(!customer.isEmpty()) {
			st=new ArrayList<>();
			Collection<Customer>cv=customer.values();
			for(Customer val:cv) st.add(val);
		}
		return st;

	}

	@Override
	public List<Stock> consolidateReport(String stockName, Map<String, Stock> stock) {
		// TODO Auto-generated method stub
		List<Stock>lv=null;
		if(stock.containsKey(stockName)) {
			lv=new ArrayList<>();
			lv.add(stock.get(stockName));
			
		}
		else {
			System.out.println("Please enter valid stock name");
		}
		return lv;
	}

//	@Override
//	public boolean deleteCustomer(String email, Map<String, Customer> customer,Map<String,Stock>stock) {
//		// TODO Auto-generated method stub
//		if(customer.containsKey(email)) {
//			
//			
//		}
//		else {
//			System.out.println("Please enter valid customer email");
//		}
//		return false;
//	}

	
}
