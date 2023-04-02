package main.sbs.services;

import java.util.List;
import main.sbs.entity.Transaction;

public interface TransactionService {

	List<Transaction> viewCustomerTransaction(String email, List<Transaction> transaction);

	void viewAllTransactions(List<Transaction> transaction);
}
