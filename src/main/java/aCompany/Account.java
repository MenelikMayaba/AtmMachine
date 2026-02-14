package aCompany;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance){

        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;

    }

    public double deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        return balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double withdraw(double amount) {
        if(amount > balance){
            throw new IllegalArgumentException("cannot withdraw more the balance");
        }

        return balance -= amount;
    }
}
