package model;

public abstract class Payment { // abstract method
    protected double amount;
    protected String transactionId;
    protected String status;

    public Payment(double amount){
        this.amount = amount;
        this.transactionId = "TX-:" + System.currentTimeMillis();
        this.status = "PENDING";
    }

    // getter for encaapsulations
    public String getTransactionId() {return transactionId;} 
    public String getStatus() {return status;}
    public double getAmount() {return amount;}

    public abstract void processPayment() throws Exception;
}
