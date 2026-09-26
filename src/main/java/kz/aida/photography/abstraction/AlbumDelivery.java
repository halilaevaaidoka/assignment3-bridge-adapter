package kz.aida.photography.abstraction;

import kz.aida.photography.implementor.DeliveryService;

public class AlbumDelivery extends PhotoDelivery {

    public AlbumDelivery(DeliveryService service) {
        super(service);
    }

    @Override
    public void send(String photoId, String recipient) {
        service.deliver("ALBUM-" + photoId, recipient);
    }
}

