package main.sbs.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import main.sbs.entity.Customer;
import main.sbs.entity.Stock;
import main.sbs.entity.Transaction;

public class FileSaver {

	@SuppressWarnings("unchecked")
	public static Map<String, Customer> customerList() {
		Map<String, Customer> cl = null;
		File f = new File("customer.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if (flag) {
				cl = new LinkedHashMap<>();
				ObjectOutputStream wr = new ObjectOutputStream(new FileOutputStream(f));
				wr.writeObject(cl);
				wr.flush();
				wr.close();
				return cl;
			} else {
				ObjectInputStream rd = new ObjectInputStream(new FileInputStream(f));
				cl = (Map<String, Customer>) rd.readObject();
				rd.close();
				return cl;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return cl;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Stock> StockList() {
		Map<String, Stock> cl = null;
		File f = new File("stock.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if (flag) {
				cl = new LinkedHashMap<>();
				ObjectOutputStream wr = new ObjectOutputStream(new FileOutputStream(f));
				wr.writeObject(cl);
				wr.flush();
				wr.close();
				return cl;
			} else {
				ObjectInputStream rd = new ObjectInputStream(new FileInputStream(f));
				cl = (Map<String, Stock>) rd.readObject();
				rd.close();
				return cl;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return cl;
	}

	@SuppressWarnings("unchecked")
	public static List<Transaction> TransactionList() {
		List<Transaction> cl = null;
		File f = new File("transaction.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if (flag) {
				cl = new ArrayList<>();
				ObjectOutputStream wr = new ObjectOutputStream(new FileOutputStream(f));
				wr.writeObject(cl);
				wr.flush();
				wr.close();
				return cl;
			} else {
				ObjectInputStream rd = new ObjectInputStream(new FileInputStream(f));
				cl = (List<Transaction>) rd.readObject();
				rd.close();
				return cl;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return cl;
	}

	@SuppressWarnings("unchecked")
	public static List<Customer> DeactivatedCustomerAccount() {
		List<Customer> cl = null;
		File f = new File("account.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			if (flag) {
				cl = new ArrayList<>();
				ObjectOutputStream wr = new ObjectOutputStream(new FileOutputStream(f));
				wr.writeObject(cl);
				wr.flush();
				wr.close();
				return cl;
			} else {
				ObjectInputStream rd = new ObjectInputStream(new FileInputStream(f));
				cl = (List<Customer>) rd.readObject();
				rd.close();
				return cl;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return cl;
	}

}
