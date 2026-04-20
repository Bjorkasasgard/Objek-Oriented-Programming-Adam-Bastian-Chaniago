public class SavingAccount extends Account {
    // encapsulationns
    private double interestRate; 
    public SavingAccount(String owenerName, double balance, double interestRate){
        super(owenerName, balance);
        this.interestRate = interestRate;
    }

    // getter dan setter
    public double getIntrestRate(){
        return interestRate;
    }
    
    public void setInterestRate(double intrestRate){
        if(intrestRate > 0 ) {
            this.interestRate = intrestRate;
        } else {
            System.out.println("Interest rate tidak valid");
        }
    }

    public void addInterest(){
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Bunga ditambahkan!");
    }

    @Override // polymorphism
    public void displayInfo(){
        System.out.println("=== savings account ===");
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rest: " + getIntrestRate());
    }
}