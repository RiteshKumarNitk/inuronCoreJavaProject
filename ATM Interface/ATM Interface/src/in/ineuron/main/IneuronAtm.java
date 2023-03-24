package in.ineuron.main;

import java.util.*;

import in.ineuron.utility.*;

public class IneuronAtm {

	private static Integer customerId;
	private static Integer customerPin;
	private static User isValidUser = null;
	private static Scanner sc = null;
	private static BankTransactionImpl ATM = null;

	public static void main(String[] args) {

		ATM = new BankTransactionImpl();

		// create new User
		Bank bank = new Bank();
		
		//1st User
		User newUser = bank.addNewCustomer("Ritesh", "Kumar", 11111);
		Account newAccount = bank.newAccount("Savings", 150000.00, newUser);

		System.out.print(newUser.getFirstName() + " " + newUser.getLastName() + " " + "created with customer Id  "
				+ newUser.getCustId()+" "+"With Account No "+newAccount.getAccountNumber());
		System.out.println();
		
		//2nd user
		User newUser2 = bank.addNewCustomer("Kanupriya", "Verma", 22222);
		Account newAccount2 = bank.newAccount("Savings", 50000.00, newUser2);
		System.out.print(newUser2.getFirstName() + " " + newUser2.getLastName() + " " + "created with customer Id  "
				+ newUser2.getCustId()+" "+"With Account No "+newAccount.getAccountNumber());
		System.out.println();
		
		//3nd user
		User newUser3 = bank.addNewCustomer("Neha", "Soni", 33333);
		Account newAccount3 = bank.newAccount("Savings", 100000.00, newUser3);
		System.out.print(newUser3.getFirstName() + " " + newUser3.getLastName() + " " + "created with customer Id  "
				+ newUser3.getCustId()+" "+"With Account No "+newAccount.getAccountNumber());
		System.out.println();


		//taking input form user
		sc = new Scanner(System.in);
		userLogin(sc,bank);

	}

	public static void userLogin(Scanner sc,Bank bank) {
		System.out.println("Enter Customer Id:");
		customerId = sc.nextInt();

		System.out.println("Enter Customer Pin:");
		customerPin = sc.nextInt();

		isValidUser = ATM.validateUser(customerId, customerPin, bank);

		System.out.println();

		if (isValidUser != null) {

			System.out.println("Hello " + isValidUser.getFirstName() + " " + isValidUser.getLastName());
			getMenu(isValidUser, sc,bank);
		} else if (isValidUser == null) {
			System.out.println("Invalid User Id or Pin. Enter Again");
			userLogin(sc,bank);
		}
	}

	// main menu prompt
	private static void getMenu(User user, Scanner sc,Bank bank) {
		int choice;
		
		// user menu
		do {
			
			System.out.println("=======*=======*=== WELCOME TO iNEURON ATM ===*=======*=======");
			
			System.out.println("1. Show Transaction History ");
			System.out.println("2. CheckBalance ");
			System.out.println("3. Withdraw ");
			System.out.println("4. Deposite ");
			System.out.println("5. Transfer Balance To Other Account ");
			System.out.println("6. Exit ");
			System.out.println();
			
			System.out.println("==============================================================");
			System.out.println("Enter Your Choice : ");
			choice = sc.nextInt();
			if (choice < 1 || choice > 6) {
				System.out.println("Invalid Choice" + " Please choose between 1-6 ");
				getMenu(user, sc,bank);
			}
			else
			{
				switch (choice) {
				case 1:
					ATM.transactionHistory(user,bank);
					menuDispAgain(user,sc,bank);
					break;
			
				}

			}

		} while (choice < 1 || choice > 5);


	}
	
	private static void menuDispAgain(User user,Scanner sc,Bank bank) {
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		   getMenu(user,sc,bank);
	}

//end of class
}
