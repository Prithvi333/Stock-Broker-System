package main.sbs.services;

import java.util.*;
import main.sbs.entity.*;
import main.sbs.exceptions.*;

public interface StockService {

	String addStock(Stock st, Map<String, Stock> stock);

	String deleteStock(String stockName, Map<String, Stock> stock) throws InvalidStockName;

	String UpdateStock(Stock stoc, Map<String, Stock> stock) throws InvalidStockName;

	List<Stock> viewStocks(Map<String, Stock> stock);

	List<Customer> viewAllCustomer(Map<String, Customer> customer);

	List<Stock> consolidateReport(String stockName, Map<String, Stock> stock);

	boolean deleteCustomer(String email, Map<String, Customer> customer, List<Transaction> transaction,
			List<Customer> custo);
}
