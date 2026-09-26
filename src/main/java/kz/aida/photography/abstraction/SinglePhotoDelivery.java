package kz.aida.photography.abstraction;

import kz.aida.photography.implementor.DeliveryService;

public class SinglePhotoDelivery extends PhotoDelivery {

    public SinglePhotoDelivery(DeliveryService service) {
        super(service);
    }

    @Override
    public void send(String photoId, String recipient) {
        service.deliver(photoId, recipient);
    }
}
