package aCompany;

import java.io.ObjectStreamException;

public class ATM {

    Account user = new Account("12345", "0000", 500);;
    private boolean isLoggedIn;

    public Account addAccount(Account account){
        return account;
    }


    public boolean login(String accNum, String pin) {
        if(!user.getAccountNumber().equals(accNum) || !user.getPin().equals(pin)){
            System.out.println("Incorrect log in details");
            return isLoggedIn = false;


        }
        return isLoggedIn = true;
    }


    public double deposit(double amount) {
        if(isLoggedIn){
            return user.deposit(amount);
        }
        else{
            throw new IllegalStateException("No user logged in");
        }

    }

    public double checkBalance() {
        if(isLoggedIn){
            return user.getBalance();
        }
        else{
            throw new IllegalStateException("No user logged in");
        }
    }

    public double withdraw(double amount) {
        if(isLoggedIn){
            return user.withdraw(amount);
        }else{
            throw new IllegalStateException("No user logged in");
        }


    }

    public void logout() {
        isLoggedIn = false;

    }
}
