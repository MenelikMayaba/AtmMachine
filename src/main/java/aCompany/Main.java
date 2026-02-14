package aCompany;


public class Main {
    public static void main(String[] args) {
        Account account = new Account("12345", "21435", 0);

        account.deposit(600);
        System.out.println(account.getBalance());


    }

}