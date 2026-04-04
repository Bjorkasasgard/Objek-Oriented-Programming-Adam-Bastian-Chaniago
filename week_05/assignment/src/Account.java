public class Account { // <- superclass
    protected String ownerName;
    private double balance; // <- data hidding

    // constructr
    public Account(String ownerName, double balance){
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // getter
    public double getBalance(){
        return balance;
    }

    //setter (controllerd)
    protected void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit berhasil sebesar " + amount);
        } else {
            System.out.println("Error msg: Ngwaurr cik, kosong loh ya");
        }
    }

    public void displayInfo(){
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + balance);
    }
}