package notification;

public class PushNotification implements Notification {
    @Override
    public void sendNotification(String transactionId, String status){
        System.out.println("[PUSH] sending push notification transaction:  " + transactionId + " status " + status);
    }
}
