package kz.aida.photography.abstraction;

import kz.aida.photography.implementor.DeliveryService;

public abstract class PhotoDelivery {

    protected final DeliveryService service;

    public PhotoDelivery(DeliveryService service) {
        this.service = service;
    }

    public abstract void send(String photoId, String recipient);
}
