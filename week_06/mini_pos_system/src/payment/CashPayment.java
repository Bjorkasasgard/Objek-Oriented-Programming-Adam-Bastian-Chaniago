package payment;
import model.Payment;

public class CashPayment extends Payment {
    
    public CashPayment(double amount) {
        super(amount); 
    }

    @Override
    public void processPayment() throws Exception {
        System.out.println("Memproses pembayaran Tunai sebesar Rp" + amount);
        if (amount <= 0) {
            this.status = "FAILED";
            throw new Exception("Nominal pembayaran tunai tidak valid!");
        }
        this.status = "SUCCESS";
    }
}