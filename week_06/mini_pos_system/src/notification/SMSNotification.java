package notification;

public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String transactionId, String status){
        System.out.println("[SMS NOTIFICATION] Sending SMS Transaction " + transactionId + " Status " + status);
    }
}
