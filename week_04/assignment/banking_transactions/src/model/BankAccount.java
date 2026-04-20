package model;
// public class BankAccount {
//     private double balance;
//     private String accountNo;
//     private String accountName;

//     public BankAccount(double balance, String accoutNo, String accountName){
//         this.balance = balance;
//         this.accountNo = accNo;
//         this.accountName = accName;
//     }

//     public void deposit(double amount){
//         this.balance =+ amount;
//     }

//     public void withdraw(double amount){
//         this.balance =- amount;
//     }

//     public double getBalance(){
//         return this.balance;
//     }

//     public String getAccountNo(){
//         return this.accountNo;
//     }
//     public String getAccountName(){
//         return this.accountName;
//     }

//     public String toString(){
//         return "Account Number :"+ this.accountName+
//         return "\nAccount Name:"+ this.accounntNo+
//         return "\nYour Balance"+ this.balance;
//     }
// }

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // 2. Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Menambah saldo
            System.out.println("Setor tunai berhasil.");
        } else {
            System.out.println("Gagal: Jumlah setoran tidak valid!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount; 
            System.out.println("Tarik tunai berhasil.");
        } else {
            System.out.println("Gagal: Saldo tidak cukup atau jumlah tidak valid!");
        }
    }
}