package GurkiratKhaira_COMP228Sec004_Ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Account A1 = new Account("A1");
		Account A2 = new Account("A2");
		Account A3 = new Account("A3");

		System.out.println("\nStarting Executor\n");
		
		// create ExecutorService to manage threads
		ExecutorService executorService = Executors.newCachedThreadPool();

		// start the three Tasks
		executorService.execute(A1); // start A1
		executorService.execute(A2); // start A2
		executorService.execute(A3); // start A3
		
	}
}