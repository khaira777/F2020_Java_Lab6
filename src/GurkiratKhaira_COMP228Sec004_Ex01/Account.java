package GurkiratKhaira_COMP228Sec004_Ex01;

import java.security.SecureRandom;
//import java.util.ArrayList;

public class Account implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private int balance = 1000;
	private final int sleepTime;
	private final String accountName;
	//private ArrayList<Integer> deposit = new ArrayList<Integer>();
	//private ArrayList<Integer> withdraw = new ArrayList<Integer>();

	public Account(String accountName) {
		this.accountName = accountName;
		System.out.println("Initial Balance in " + accountName + " is $" + balance);
		// pick random sleep time between 0 and 3 seconds
		sleepTime = generator.nextInt(3000); // milliseconds
	}

	public synchronized void deposit(int _deposit) {
		if (_deposit > 0) {
			balance = balance + _deposit;
		} else {
			System.out.println("$" + _deposit + " isn't enough money to deposit");
		}
		System.out.println("$" + _deposit + " deposited to " + accountName + ". Current balance: $" + balance);
	}

	public synchronized void withdraw(int _withdraw) {
		if (balance >= _withdraw) {
			balance = balance - _withdraw;
		} else {
			System.out.println(accountName + " doesn't have enough balance.");
		}
		System.out.println("$" + _withdraw + " withdrew from " + accountName + ". Current balance: $" + balance);
	}

	@Override
	public void run() {
		try {
			// withdraw and deposit operations
			int valuew = generator.nextInt(200);
			int valued = generator.nextInt(200);

			//deposit.add(valued);
			//withdraw.add(valuew);
			
			withdraw(valuew);
			deposit(valued);

			// put thread to sleep
			Thread.sleep(sleepTime);
		} catch (InterruptedException exception) {
			Thread.currentThread().interrupt();
		}
	}
}
