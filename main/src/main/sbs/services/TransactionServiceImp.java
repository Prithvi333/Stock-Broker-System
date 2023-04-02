package main.sbs.services;

import java.util.*;
import main.sbs.entity.Transaction;

public class TransactionServiceImp implements TransactionService {

	public List<Transaction> viewCustomerTransaction(String email, List<Transaction> transaction) {
		List<Transaction> tl = null;

		if (!transaction.isEmpty()) {
			tl = new ArrayList<>();
			for (Transaction tr : transaction) {
				if (tr.getEmail().equals(email)) {
					tl.add(tr);
				}
			}
			return tl;
		} else
			System.out.println("There is no transaction with this email yet");

		return tl;
	}

	public void viewAllTransactions(List<Transaction> transaction) {
		if (!transaction.isEmpty()) {
			for (Transaction tr : transaction) {
				System.out.println(tr);
			}
		} else
			System.out.println("There is not any single transaction right now");
	}

}
