import javax.tools.StandardJavaFileManager;

public class BankAccount{
    double checkingBalance;
    double savingsBalance;
    public static int accounts;
    public static double moneyStored;
    public static String accountNumber; 

    public BankAccount(){
        checkingBalance = 20;
        savingsBalance = 100;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void depositMoney(double amount, String account){
        if (account == "Checking"){
            checkingBalance += amount;
        }
        else if (account == "Savings"){
            savingsBalance += amount;
        }
    }

    public void withdrawMoney(double amount, String account){
        if (account == "Checking" && checkingBalance > 0){
            checkingBalance -= amount;
        }
        else if (account == "Savings" && savingsBalance > 0){
            savingsBalance -= amount;
        }
        else{
            System.out.println("Insufficient funds.");
        }
    }

    public void totalBalance(){
        System.out.printf("Checkings: %s\n", checkingBalance);
        System.out.printf("Savings: %s\n", savingsBalance);
    }


}