package main;

import java.util.ArrayList;
import java.util.List;
import model.Payment;
import notification.EmailNotification;
import notification.Notification;
import notification.PushNotification;
import notification.SMSNotification;
import payment.BankTransfer;
import payment.CashPayment;
import payment.EWallet;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MINI POS SYSTEM ===");

        List<Payment> transactionHistory = new ArrayList<>();
        
        Payment p1 = new CashPayment(50000);
        Payment p2 = new EWallet(150000, "GoPay");
        Payment p3 = new BankTransfer(300000, "BCA");
        Payment p4 = new CashPayment(0); 

        Notification notifEmail = new EmailNotification();
        Notification notifSms = new SMSNotification();
        Notification notifPush = new PushNotification();

        processTransaction(p1, notifSms, transactionHistory);
        processTransaction(p2, notifPush, transactionHistory);
        processTransaction(p3, notifEmail, transactionHistory);
        processTransaction(p4, notifEmail, transactionHistory); 

        System.out.println("\n=== RIWAYAT TRANSAKSI ===");
        for (Payment history : transactionHistory) {
            System.out.println("ID: " + history.getTransactionId() + 
                               " | Nominal: Rp" + history.getAmount() + 
                               " | Status: " + history.getStatus());
        }
    }

    public static void processTransaction(Payment payment, Notification notification, List<Payment> history) {
        System.out.println("\n--- Memulai Transaksi Baru ---");
        
        // (try-catch)
        try {
            payment.processPayment(); 
            System.out.println("Pembayaran berhasil diproses.");
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        } finally {
            notification.sendNotification(payment.getTransactionId(), payment.getStatus());
            history.add(payment);
        }
    }
}