package payment;
import model.Payment;

public class BankTransfer extends Payment {
    private String bankName;

    public BankTransfer(double amount, String bankName) {
        super(amount);
        this.bankName = bankName;
    }

    @Override
    public void processPayment() throws Exception {
        System.out.println("Memproses Transfer Bank (" + bankName + ") sebesar Rp" + amount);
        this.status = "SUCCESS";
    }
}