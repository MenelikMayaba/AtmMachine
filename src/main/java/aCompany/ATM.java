package aCompany;

public class ATM {

    Account account = new Account("12345", "0000", 500);;
    private boolean isLoggedIn = true;

    public Account addAccount(Account account){
        return account;
    }


    public boolean login(String accNum, String pin) {
        if(!account.getAccountNumber().equals(accNum) || !account.getPin().equals(pin)){
            System.out.println("Incorrect log in details");
            return false;

        }
        return isLoggedIn;
    }


    public double deposit(double amount) {
        return account.deposit(amount);
    }

    public int checkBalance() {
        return (int) account.getBalance();
    }

    public double withdraw(double amount) {
        return account.withdraw(amount);
    }

    public void logout() {
    }
}
