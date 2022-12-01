public class TestBankAccount {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        account1.depositMoney(50, "Checking");
        account1.withdrawMoney(70, "Savings");
        account1.depositMoney(230, "Savings");
        account1.withdrawMoney(20, "Checking");
        account1.totalBalance();
    }
}