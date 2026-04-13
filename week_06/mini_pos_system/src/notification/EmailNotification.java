package notification;

public class EmailNotification implements Notification{
    @Override
    public void sendNotification(String transactionId, String status){
        System.out.println("[Email] Sending email... Transaction: " + transactionId + " Setatus: " + status);
    }
}