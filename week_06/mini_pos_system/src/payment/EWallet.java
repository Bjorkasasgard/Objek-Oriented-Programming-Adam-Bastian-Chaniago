package payment;
import model.Payment;

public class EWallet extends Payment {
    private String provider;

    public EWallet(double amount, String provider) {
        super(amount);
        this.provider = provider;
    }

    @Override
    public void processPayment() throws Exception {
        System.out.println("Memproses pembayaran E-Wallet (" + provider + ") sebesar Rp" + amount);
        if (Math.random() > 0.8) { 
            this.status = "FAILED";
            throw new Exception("Koneksi ke server E-Wallet " + provider + " terputus!");
        }
        this.status = "SUCCESS";
    }
}