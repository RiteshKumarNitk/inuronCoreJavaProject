/*Create a Java program that simulates a bank account. The program should allow
users to deposit and withdraw money, check their balance.*/
package corejava;
import java.util.Scanner;

class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

interface Bank {
    void withdraw(double amount);
    void deposit(double amount);
}

class SBI implements Bank {
    private double accountBalance;

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > this.accountBalance) {
            throw new InsufficientBalanceException("Insufficient balance to withdraw");
        } else {
            this.accountBalance -= amount;
            System.out.println(amount + " has been deducted from your account...");
            System.out.println("Your updated balance is: " + getAccountBalance());
        }
    }

    @Override
    public void deposit(double amount) {
        this.accountBalance += amount;
        System.out.println(amount + " has been deposited");
        System.out.println("Your updated balance is: " + getAccountBalance());
    }
}

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance;
        SBI sbi = new SBI();
        sbi.setAccountBalance(100000);
        int choice;

        while (true) {
            System.out.println("1. Know your account balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your account balance is: " + sbi.getAccountBalance());
                    break;
                case 2:
                    try {
                        System.out.print("Enter the amount you want to withdraw: ");
                        balance = scanner.nextDouble();
                        sbi.withdraw(balance);
                    } catch (InsufficientBalanceException ex) {
                        ex.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter the amount you want to deposit: ");
                        balance = scanner.nextDouble();
                        sbi.deposit(balance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
