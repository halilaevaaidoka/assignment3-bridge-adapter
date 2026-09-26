package kz.aida.photography.implementor;

public class EmailDeliveryService implements DeliveryService {

    @Override
    public void deliver(String photoId, String recipient) {
        System.out.println(
                "Email delivery: " + photoId + " to " + recipient
        );
    }
}