package com.skillstorm;

public class BankAccountEncapsulation {

    public static void main(String[] args) {

        System.out.println("--- Creating newAccount1 (initial balance $100) ---");
        try {
            Account newAccount1 = new Account("Jeff", 1234567891234567L, 100); 
            System.out.println("Your Account Name is: " + newAccount1.getaccountName() + "\nYour Account Number is: " + newAccount1.getaccountNumber() + "\nYour Account Balance is: $" + newAccount1.getaccountBalance());

            System.out.println("\n--- Attempting to deposit $100 into Jeff's account ---");
            newAccount1.depositAmount(100);
            System.out.println("Jeff's new balance is: $" + newAccount1.getaccountBalance());

            System.out.println("\n--- Attempting to deposit invalid amount ($-50) ---");
            newAccount1.depositAmount(-50); 
            System.out.println("Jeff's balance after invalid deposit: $" + newAccount1.getaccountBalance()); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error for Account 1 operation: " + e.getMessage());
        }

        System.out.println("\n---------------------------------------------------------");

        System.out.println("--- Creating newAccount2 (initial balance $7,879,258) ---");
        try {
            Account newAccount2 = new Account("Tasha", 1234567891234567L, 7879258);
            System.out.println("Your Account Name is: " + newAccount2.getaccountName() + "\nYour Account Number is: " + newAccount2.getaccountNumber() + "\nYour Account Balance is: $" + newAccount2.getaccountBalance());
            
            System.out.println("\n--- Attempting to withdraw: $1,000 ---");
            newAccount2.withdrawalAmount(1000);
            System.out.println("Tasha's new balance is: $" + newAccount2.getaccountBalance());
            
            System.out.println("\n--- Attempting to deposit: $10,000 ---");
            newAccount2.depositAmount(10000);
            System.out.println("Tasha's new balance is: $" + newAccount2.getaccountBalance());
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error for Account 2 operation: " + e.getMessage());
        }
    }
}

class Account {

    private String accountName;
    private long accountNumber;
    private int accountBalance;

    public Account(String accountName, long accountNumber, int accountBalance) {
        this.accountName = accountName;
        this.setaccountNumber(accountNumber);
        this.setaccountBalance(accountBalance);
    }

    public String getaccountName() {
        return this.accountName;
    }

    public final long getaccountNumber() {
        return this.accountNumber;
    }

    public void setaccountNumber(long accountNumber) {
        if (accountNumber < 1000000000000000L || accountNumber > 9999999999999999L) {
            throw new IllegalArgumentException("Account Number Must Be 16-digits long.");
        }
        this.accountNumber = accountNumber;
    }

    public int getaccountBalance() {
        return this.accountBalance;
    }

    
    public void setaccountBalance(int accountBalance) {
        if (accountBalance < 0) {
            System.out.println("Warning: Account initialized with a negative balance.");

            
        }
        this.accountBalance = accountBalance;
    }

    
    public void depositAmount(int deposit) {
        if (deposit <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than $0.");
        }

        this.accountBalance += deposit;
        System.out.println("You've successfully deposited: $" + deposit); 
    }
    
    public void withdrawalAmount(int withdraw) {
    	if (this.accountBalance < withdraw) { 
    	        throw new IllegalArgumentException("Account balance ($" + this.accountBalance + ") not sufficient for withdrawal of $" + withdraw + ".");
    	    }
    	this.accountBalance -= withdraw;
        System.out.println("You've successfully withdrawn: $" + withdraw);
    	
    }
   
}