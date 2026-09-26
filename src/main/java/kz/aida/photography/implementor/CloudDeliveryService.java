package kz.aida.photography.implementor;

public class CloudDeliveryService implements DeliveryService {

    @Override
    public void deliver(String photoId, String recipient) {
        System.out.println(
                "Cloud delivery: " + photoId + " to " + recipient
        );
    }
}