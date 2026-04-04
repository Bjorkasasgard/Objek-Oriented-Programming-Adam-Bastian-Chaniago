import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Payment> payments = new ArrayList<>();

        payments.add(new CreditCardPayment(100.0, "1234-5678", "Adam"));
        payments.add(new PayPalPayment(50.0, "adam@email.com"));
        payments.add(new CryptoPayment(200.0, "0xABC123XYZ"));

        for (Payment p : payments) {
            p.processPayment();
        }
    }
}