package com.skillstorm;

// Main class to demonstrate bank account functionality using encapsulation
public class BankAccountEncapsulation {

    public static void main(String[] args) {
        // Test case 1: Creating and manipulating Jeff's account
        System.out.println("--- Creating Jeff's Account (initial balance $100) ---");
        try {
            // Instantiate a new Account object for Jeff
            Account newAccount1 = new Account("Jeff", "1234567891234567", 100);
            // Display account details using getter methods
            System.out.println("Your Account Name is: " + newAccount1.getAccountName() + 
                               "\nYour Account Number is: " + newAccount1.getAccountNumber() + 
                               "\nYour Account Balance is: $" + newAccount1.getAccountBalance());

            System.out.println("\n--- Attempting to deposit $100 into Jeff's account ---");
            // Deposit $100 into Jeff's account
            newAccount1.depositAmount(100);
            System.out.println("Jeff's new balance is: $" + newAccount1.getAccountBalance());

            System.out.println("\n--- Attempting to deposit invalid amount ($-50) ---");
            // Attempt to deposit a negative amount (should throw an exception)
            newAccount1.depositAmount(-50);
            System.out.println("Jeff's balance after invalid deposit: $" + newAccount1.getAccountBalance());
        } catch (IllegalArgumentException e) {
            // Handle any validation errors during account operations
            System.out.println("Error for Account 1 operation: " + e.getMessage());
        }

        System.out.println("\n---------------------------------------------------------");

        // Test case 2: Creating and manipulating Tasha's account
        System.out.println("--- Creating Tasha's Account (initial balance $7,879,258) ---");
        try {
            // Instantiate a new Account object for Tasha's account
            Account newAccount2 = new Account("Tasha", "1234567891234567", 7879258);
            System.out.println("Your Account Name is: " + newAccount2.getAccountName() + 
                               "\nYour Account Number is: " + newAccount2.getAccountNumber() + 
                               "\nYour Account Balance is: $" + newAccount2.getAccountBalance());

            System.out.println("\n--- Attempting to withdraw: $1,000 ---");
            // Withdraw $1,000 from Tasha's account
            newAccount2.withdrawalAmount(1000);
            System.out.println("Tasha's new balance is: $" + newAccount2.getAccountBalance());

            System.out.println("\n--- Attempting to deposit: $10,000 ---");
            // Deposit $10,000 into Tasha's account
            newAccount2.depositAmount(10000);
            System.out.println("Tasha's new balance is: $" + newAccount2.getAccountBalance());
           

            System.out.println("\n--- Attempting to withdraw more than balance: $8,000,000 (should fail) ---");
            // Attempt to withdraw more than the balance (should throw an exception)
            newAccount2.withdrawalAmount(8000000);
            System.out.println("Tasha's balance after invalid withdrawal: $" + newAccount2.getAccountBalance());
        } catch (IllegalArgumentException e) {
            // Handle any validation errors during account operations
            System.out.println("Error for Account 2 operation: " + e.getMessage());
        }

        System.out.println("\n---------------------------------------------------------");

        // Test case 3: Attempting to create an account with a negative balance
        System.out.println("--- Testing initial negative balance for Tom's Account (should fail) ---");
        try {
            // Attempt to create an account with a negative balance (should throw an exception)
            Account newAccount3 = new Account("Tom", "9876543210987654", -10);
            System.out.println("Your Account Name is: " + newAccount3.getAccountName() + 
                               "\nYour Account Number is: " + newAccount3.getAccountNumber() + 
                               "\nYour Account Balance is: $" + newAccount3.getAccountBalance());
        } catch (IllegalArgumentException e) {
            // Handle error for invalid initial balance
            System.out.println("Error creating Account 3: " + e.getMessage());
        }

        System.out.println("\n---------------------------------------------------------");

        // Test case 4: Attempting to create an account with an invalid name
        System.out.println("--- Testing invalid account name ---");
        try {
            // Attempt to create an account with an invalid name (contains special characters)
            Account newAccount4 = new Account("J@ne", "1111222233334444", 500);
            System.out.println("Jane's Account: " + newAccount4.getAccountName());
        } catch (IllegalArgumentException e) {
            // Handle error for invalid account name
            System.out.println("Error creating Jane's account: " + e.getMessage());
        }

        System.out.println("\n---------------------------------------------------------");

        // Test case 5: Testing SavingsAccount with insufficient initial balance
        System.out.println("--- Testing SavingsAccount (initial balance $400 - should fail due to minBalance) ---");
        try {
            // Attempt to create a SavingsAccount with balance below minimum (should throw an exception)
            SavingsAccount newSavings1 = new SavingsAccount("Brittan", "9876543210987654", 400, 0.015);
            System.out.println("Brittan's Savings Account Name is: " + newSavings1.getAccountName() + 
                               "\nBalance: $" + newSavings1.getAccountBalance());
        } catch (IllegalArgumentException e) {
            // Handle error for invalid savings account creation
            System.out.println("Error creating Brittan's Savings Account: " + e.getMessage());
        }

        System.out.println("\n--- Testing SavingsAccount (initial balance $600 - should succeed) ---");
        try {
            // Create a valid SavingsAccount for David
            SavingsAccount newSavings2 = new SavingsAccount("David", "1122334455667788", 600, 0.02);
            System.out.println("David's Savings Account Name is: " + newSavings2.getAccountName() + 
                               "\nBalance: $" + newSavings2.getAccountBalance());
            // Apply interest to David's savings account
            newSavings2.applyInterest();
            System.out.println("David's balance after interest: $" + newSavings2.getAccountBalance());

            System.out.println("\n--- Attempting to withdraw from Savings Account ($200) ---");
            // Withdraw $200 from David's savings account
            newSavings2.withdrawalAmount(200);
            System.out.println("David's new balance after withdrawal: $" + newSavings2.getAccountBalance());

            System.out.println("\n--- Attempting to withdraw from Savings Account (another $200 - should fail, drops below min) ---");
            // Attempt to withdraw $200, which would drop balance below minimum (should throw an exception)
            newSavings2.withdrawalAmount(200);
            System.out.println("David's balance after second withdrawal: $" + newSavings2.getAccountBalance());
        } catch (IllegalArgumentException e) {
            // Handle errors for David's savings account operations
            System.out.println("Error for David's Savings Account: " + e.getMessage());
        }
    }
}

// Base class representing a generic bank account with encapsulated fields
class Account {
    // Private fields to enforce encapsulation
    private String accountName;
    private String accountNumber;
    private int accountBalance;

    // Constructor to initialize account with validation
    public Account(String accountName, String accountNumber, int accountBalance) {
        this.setAccountName(accountName);
        this.setAccountNumber(accountNumber);
        this.setAccountBalance(accountBalance);
    }

    // Getter for account name
    public String getAccountName() {
        return this.accountName;
    }

    // Getter for account number
    public String getAccountNumber() {
        return this.accountNumber;
    }

    // Getter for account balance
    public int getAccountBalance() {
        return this.accountBalance;
    }

    // Setter for account name with validation
    public void setAccountName(String accountName) {
 

       // Validate that account name is not null or empty
        if (accountName == null || accountName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account Name cannot be empty or just spaces.");
        }
        String trimmedName = accountName.trim();
        // Ensure account name length is between 3 and 50 characters
        if (trimmedName.length() < 3 || trimmedName.length() > 50) {
            throw new IllegalArgumentException("Account Name must be between 3 and 50 characters long.");
        }
        // Restrict account name to letters, spaces, hyphens, and apostrophes
        if (!trimmedName.matches("[a-zA-Z\\s'-]+")) {
            throw new IllegalArgumentException("Account Name contains invalid characters. Only letters, spaces, hyphens, and apostrophes are allowed.");
        }
        this.accountName = trimmedName;
    }

    // Setter for account number with validation
    public void setAccountNumber(String accountNumber) {
        // Validate that account number is not null or empty
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account Number cannot be null or empty.");
        }
        // Ensure account number is exactly 16 digits
        if (accountNumber.length() != 16) {
            throw new IllegalArgumentException("Account Number Must Be 16 characters long.");
        }
        // Ensure account number contains only digits
        if (!accountNumber.matches("\\d+")) {
             throw new IllegalArgumentException("Account Number must consist only of digits.");
        }
        this.accountNumber = accountNumber;
    }

    // Setter for account balance with validation
    public void setAccountBalance(int accountBalance) {
        // Prevent negative initial balance
        if (accountBalance < 0) {
            throw new IllegalArgumentException("Initial account balance cannot be negative.");
        }
        this.accountBalance = accountBalance;
    }

    // Method to deposit money into the account
    public void depositAmount(int deposit) {
        // Ensure deposit amount is positive
        if (deposit <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than $0.");
        }
        this.accountBalance += deposit;
        System.out.println("You've successfully deposited: $" + deposit);
    }

    // Method to withdraw money from the account
    public void withdrawalAmount(int withdraw) {
        // Ensure withdrawal amount is positive
        if (withdraw <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than $0.");
        }
        // Check for sufficient funds
        if (this.accountBalance < withdraw) {
            throw new IllegalArgumentException("Account balance ($" + this.accountBalance + ") not sufficient for withdrawal of $" + withdraw + ".");
        }
        this.accountBalance -= withdraw;
        System.out.println("You've successfully withdrawn: $" + withdraw);
    }
}

// Subclass representing a savings account with additional features
class SavingsAccount extends Account {
    // Interest rate for the savings account
    private double interestRate;
    // Constant defining the minimum required balance
    private static final int MINIMUM_BALANCE = 500;

    // Constructor to initialize savings account with interest rate
    public SavingsAccount(String accountName, String accountNumber, int accountBalance, double interestRate) {
        super(accountName, accountNumber, accountBalance);
        this.interestRate = interestRate;
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter for minimum balance
    public int getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    // Override to enforce minimum balance for savings account
    @Override
    public void setAccountBalance(int accountBalance) {
        // Ensure initial balance meets minimum requirement
        if (accountBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Savings account initial balance must be at least $" + MINIMUM_BALANCE + ". Provided: $" + accountBalance);
        }
        super.setAccountBalance(accountBalance);
    }

    // Override to prevent withdrawals that drop balance below minimum
    @Override
    public void withdrawalAmount(int withdraw) {
        // Calculate potential balance after withdrawal
        int potentialNewBalance = this.getAccountBalance() - withdraw;
        // Check if withdrawal would violate minimum balance
        if (potentialNewBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Withdrawal of $" + withdraw + " would cause balance to drop below minimum required balance of $" + MINIMUM_BALANCE + ". Current balance: $" + this.getAccountBalance());
        }
        super.withdrawalAmount(withdraw);
    }

    // Method to apply interest to the account balance
    public void applyInterest() {
        // Calculate interest based on current balance and interest rate
        double interestAmount = this.getAccountBalance() * interestRate;
        // Deposit interest amount (cast to int for consistency with balance)
        this.depositAmount((int) interestAmount);
        System.out.println("Interest applied (" + (interestRate * 100) + "%).");
    }
}