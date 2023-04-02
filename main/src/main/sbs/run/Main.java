package main.sbs.run;

import java.io.*;
import java.util.*;

import main.sbs.entity.*;
import main.sbs.exceptions.*;
import main.sbs.services.*;
import main.sbs.utility.*;

public class Main {
	private static void adminFunctionality(Scanner sc, Map<String, Customer> customer, Map<String, Stock> stock,
			List<Transaction> transaction, List<Customer> deactivatedCustomer) throws InvalidCredentials {
		StockServiceImp ss = new StockServiceImp();
		TransactionServiceImp ts = new TransactionServiceImp();
		adminSignin(sc);

		try {
			int choice = 0;
			do {
				System.out.println(
						"1->Press 1 to add stock\n 2->Press 2 to delete stock\n 3->Press 3 to update stock\n 4->Press 4 to view stock\n 5->Press 5 to view all customer\n 6->Press 6 to delete customers\n 7->Press 7 to get information about stock\n 8->Press 8 to view customer transaction\n 9->Press 9 to view all transactions\n 0->Press 0 to exit!");
				choice = sc.nextInt();
				switch (choice) {
				case 0:
					System.out.println("Successfully exited");
					break;
				case 1:
					addStock(sc, stock, ss);
					break;
				case 2:
					deleteStock(sc, stock, ss);
					break;
				case 3:
					updateStock(sc, stock, ss);
					break;
				case 4:
					viewStocks(sc, stock, ss);
					break;
				case 5:
					viewAllCustomer(sc, customer, ss);
					break;
				case 6:
					deleteCustomer(sc, customer, deactivatedCustomer, transaction, ss);
					break;
				case 7:
					consolidateReport(sc, stock, ss);
					break;
				case 8:
					viewCustomerTransaction(sc, transaction, ts);
					break;
				case 9:
					viewAllTransactions(transaction, ts);
					break;
				default:
					System.out.println("Please enter valid input");
					;
				}
			} while (choice != 0);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void adminSignin(Scanner sc) throws InvalidCredentials {
		boolean flag = false;
		do {
			System.out.println("Please enter the username");
			String uname = sc.next();
			System.out.println("Please enter the password");
			String passcode = sc.next();
			if (!uname.equals(AdminLog.userName))
				System.out.println("Please enter valid user name");
			else if (!passcode.equals(AdminLog.passWord))
				System.out.println("Please enter valid password");
			try {
				if (!(uname.equals(AdminLog.userName) && passcode.equals(AdminLog.passWord)))
					throw new InvalidCredentials("Please enter valid username and password");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (uname.equals(AdminLog.userName) && passcode.equals(AdminLog.passWord))
				flag = true;
		} while (!flag);
		System.out.println("Admin login successfully");
	}

	public static void addStock(Scanner sc, Map<String, Stock> stockList, StockServiceImp ss) {
		System.out.println("Please enter the stock name you want to add");
		String sname = sc.next();
		System.out.println("Please enter the price of stock");
		int sprice = sc.nextInt();
		Stock stock = new Stock(sname, sprice);
		System.out.println(ss.addStock(stock, stockList));
	}

	public static void deleteStock(Scanner sc, Map<String, Stock> stockList, StockServiceImp ss) {
		System.out.println("Please enter the stock name you want to delete");
		String sname = sc.next();
		try {
			System.out.println(ss.deleteStock(sname, stockList));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void updateStock(Scanner sc, Map<String, Stock> stockList, StockServiceImp ss) {
		System.out.println("Plese enter the details of stock you want to update");
		System.out.println("Please enter the stock name you want to add");
		String sname = sc.next();
		System.out.println("Please enter the price of stock");
		int sprice = sc.nextInt();
		Stock stock = new Stock(sname, sprice);
		try {
			System.out.println(ss.UpdateStock(stock, stockList));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void viewStocks(Scanner sc, Map<String, Stock> stockList, StockServiceImp ss) {
		List<Stock> stock = ss.viewStocks(stockList);
		if (stock != null) {
			for (Stock val : stock)
				System.out.println(val);
		} else
			System.out.println("Stock list is empty");
	}

	public static void viewAllCustomer(Scanner sc, Map<String, Customer> customerList, StockServiceImp ss) {
		List<Customer> customers = ss.viewAllCustomer(customerList);
		if (customers != null) {
			for (Customer val : customers)
				System.out.println(val);
		} else
			System.out.println("Customer list is empty");

	}

	public static void deleteCustomer(Scanner sc, Map<String, Customer> customerList, List<Customer> deactivate,
			List<Transaction> transaction, StockServiceImp ss) {
		System.out.println("Please enter the email of the customer you want to delete");
		String email = sc.next();
		boolean operation = ss.deleteCustomer(email, customerList, transaction, deactivate);
		if (operation)
			System.out.println("Account is successfully deactivated");
	}

	public static void consolidateReport(Scanner sc, Map<String, Stock> stock, StockServiceImp ss) {
		System.out.println("Please enter the name of stock to get details");
		String stk = sc.next();
		List<Stock> st = ss.consolidateReport(stk, stock);
		if (!st.isEmpty())
			for (Stock val : st) {
				int quantity = 500 - val.getQuantity();
				System.out.println("Stock quantity already sold " + quantity);
				System.out.println("Stock quantity left " + val.getQuantity());
			}
	}

	public static void viewCustomerTransaction(Scanner sc, List<Transaction> transaction, TransactionServiceImp ts) {
		System.out.println("Please enter your email id");
		String email = sc.next();
		List<Transaction> translist = ts.viewCustomerTransaction(email, transaction);
		if (translist != null) {
			for (Transaction val : translist)
				System.out.println(val);
		} else
			System.out.println("Soory transaction list is empty");
	}

	public static void viewAllTransactions(List<Transaction> transactions, TransactionServiceImp ts) {
		ts.viewAllTransactions(transactions);
	}

	public static void customerFunctionality(Scanner sc, Map<String, Customer> customer, Map<String, Stock> stock,
			List<Transaction> transaction, List<Customer> deactivatedCustomer) {

		CustomerServiceImp cs = new CustomerServiceImp();
		boolean result = customerSignIn(sc, customer, cs);
		if (result) {
			try {
				int choice = 0;
				do {
					System.out.println(
							"1->Press 1 to buy stocks\n 2->Press 2 to sell stocks\n 3->Press 3 to view wallet balance\n 4->Press 4 to add money to wallet\n 5->Press 5 to withdraw money\n 6->Press 6 to view your details\n 7->Press 7 to view my transaction\n 0->Press 0 to exit!");
					choice = sc.nextInt();
					switch (choice) {
					case 0:
						System.out.println("Successfully exited");
						break;
					case 1:
						buyStock(sc, customer, stock, transaction, deactivatedCustomer, cs);
						break;
					case 2:
						sellStock(sc, customer, stock, transaction, cs);
						break;
					case 3:
						viewWalletBalance(sc, customer, cs);
						break;
					case 4:
						addWalletMoney(sc, customer, deactivatedCustomer, cs);
						break;
					case 5:
						withdrawMoney(sc, customer, transaction, cs);
						break;
					case 6:
						viewMyDetails(sc, customer, cs);
						break;
					case 7:
						viewMyTransactions(sc, transaction, cs);
						break;
					default:
						System.out.println("Please eneter valid input");
					}

				} while (choice != 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static boolean customerSignIn(Scanner sc, Map<String, Customer> customer, CustomerServiceImp cs) {
		System.out.println("Welcome to login");
		System.out.println("Please enter your email");
		String email = sc.next();
		System.out.println("Please enter your password");
		String passcode = sc.next();
		try {
			boolean sig = cs.signIn(email, passcode, customer);
			if (sig)
				System.out.println("Sigin Successfully!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void buyStock(Scanner sc, Map<String, Customer> customer, Map<String, Stock> stock,
			List<Transaction> transaction, List<Customer> inactive, CustomerServiceImp cs) {

		System.out.println("Plese enter required details to buy stock");
		System.out.println("Please enter user name");
		String uname = sc.next();
		System.out.println("Please enter email");
		String email = sc.next();
		System.out.println("Please enter name of the stock you want to buy");
		String sname = sc.next();
		System.out.println("Please enter quantity of stock");
		int quant = sc.nextInt();
		try {
			System.out.println(cs.buyStocks(uname, email, sname, quant, stock, customer, transaction, inactive));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sellStock(Scanner sc, Map<String, Customer> customer, Map<String, Stock> stock,
			List<Transaction> transaction, CustomerServiceImp cs) {

		System.out.println("Plese enter required details to sell stock");
		System.out.println("Please enter user name");
		String uname = sc.next();
		System.out.println("Please enter email");
		String email = sc.next();
		System.out.println("Please enter name of the stock you want to sell");
		String sname = sc.next();
		System.out.println("Please enter quantity of stock");
		int quant = sc.nextInt();
		try {
			String str = cs.sellStocks(uname, email, sname, quant, stock, customer, transaction);
			if (str != null)
				System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void viewWalletBalance(Scanner sc, Map<String, Customer> customer, CustomerServiceImp cs)
			throws InvalidEmail {
		System.out.println("Plese enter your email to view your balance");
		String email = sc.next();
		System.out.println("Your current balance is " + cs.viewWalletBalance(email, customer));
	}

	public static void addWalletMoney(Scanner sc, Map<String, Customer> customer, List<Customer> inactive,
			CustomerServiceImp cs) throws InvalidEmail {

		System.out.println("Please enter your email");
		String email = sc.next();
		System.out.println("Please enter amount you want to add");
		double amount = sc.nextDouble();
		System.out.println(cs.addWalletMoney(email, amount, customer, inactive));
	}

	public static void withdrawMoney(Scanner sc, Map<String, Customer> customer, List<Transaction> transaction,
			CustomerServiceImp cs) {
		System.out.println("Please fullfill some details to withdraw money");
		System.out.println("Enter your email");
		String email = sc.next();
		System.out.println("Enter your password");
		String passcode = sc.next();
		System.out.println("Enter amount you want to withdraw");
		double amount = sc.nextDouble();

		cs.withdrawMoney(email, passcode, amount, customer, transaction);
	}

	public static void viewMyDetails(Scanner sc, Map<String, Customer> customer, CustomerServiceImp cs)
			throws InvalidEmail {
		System.out.println("Please enter you email id");
		String email = sc.next();
		try {
			System.out.println(cs.viewMyDetails(email, customer));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void viewMyTransactions(Scanner sc, List<Transaction> transaction, CustomerServiceImp cs) {
		System.out.println("Please enter your email to see your all transactions");
		String email = sc.next();

		List<Transaction> trans = cs.viewMyTransactions(email, transaction);
		if (trans != null) {
			for (Transaction val : trans)
				System.out.println(val);
		} else
			System.out.println("No transaction found with this email");
	}

	public static void customerSignUp(Scanner sc, Map<String, Customer> customer) {
		CustomerServiceImp cs = new CustomerServiceImp();
		System.out.println("Please enter the customer details");
		System.out.println("Please enter your first name");
		String fname = sc.next();
		System.out.println("Please enetr your last name");
		String lname = sc.next();
		System.out.println("Please enter your user name ");
		String uname = sc.next();
		System.out.println("Please enter your password");
		String passcode = sc.next();
		System.out.println("Please enter you email");
		String email = sc.next();
		System.out.println("Please enter you mobile number");
		long mno = sc.nextLong();
		System.out.println("Please enter you address");
		String address = sc.next();
		System.out.println("Please enter you wallet balance");
		double wb = sc.nextDouble();

		Customer cust = new Customer(fname, lname, uname, passcode, email, mno, address, "activated", wb);
		try {
			cs.signUp(cust, customer);
			System.out.println("Customer is added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Map<String, Customer> customer = FileSaver.customerList();
		Map<String, Stock> stock = FileSaver.StockList();
		List<Transaction> transaction = FileSaver.TransactionList();
		List<Customer> deactivatedCustomer = FileSaver.DeactivatedCustomerAccount();

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Stock Broker System");

		try {
			int choice = 0;
			do {
				System.out.println(
						"Please enter your choice\n 1->Admin Login\n 2->Customer Login\n 3->Customer sign Up\n 0->Exit the application");
				choice = sc.nextInt();
				switch (choice) {
				case 0:
					System.out.println("Successfully exited");
					break;
				case 1:
					adminFunctionality(sc, customer, stock, transaction, deactivatedCustomer);
					break;
				case 2:
					customerFunctionality(sc, customer, stock, transaction, deactivatedCustomer);
					break;
				case 3:
					customerSignUp(sc, customer);
					break;
				default:
					System.out.println("Please enter valid input");
				}

			} while (choice != 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ObjectOutputStream cst = new ObjectOutputStream(new FileOutputStream("customer.ser"));
				cst.writeObject(customer);
				cst.flush();
				cst.close();
				ObjectOutputStream sto = new ObjectOutputStream(new FileOutputStream("stock.ser"));
				sto.writeObject(stock);
				sto.flush();
				sto.close();
				ObjectOutputStream trn = new ObjectOutputStream(new FileOutputStream("transaction.ser"));
				trn.writeObject(transaction);
				trn.flush();
				trn.close();
				ObjectOutputStream act = new ObjectOutputStream(new FileOutputStream("account.ser"));
				act.writeObject(deactivatedCustomer);
				act.flush();
				act.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}
}
