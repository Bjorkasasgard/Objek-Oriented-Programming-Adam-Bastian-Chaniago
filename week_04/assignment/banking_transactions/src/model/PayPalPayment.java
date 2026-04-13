package model;

public class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    public void processPayment() {
        System.out.println("Payment of $" + amount + " processed using PayPal");
        System.out.println("Email: " + email);
        System.out.println("-----------------------------------");
    }
}