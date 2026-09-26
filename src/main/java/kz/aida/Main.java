package kz.aida;

import kz.aida.photography.abstraction.*;
import kz.aida.photography.adapter.LegacyDeliveryAdapter;
import kz.aida.photography.legacy.LegacyPhotoService;
import kz.aida.photography.selection.DeliveryServiceSelector;
import kz.aida.photography.implementor.DeliveryService;
import kz.aida.photography.implementor.CloudDeliveryService;
import kz.aida.photography.implementor.EmailDeliveryService;




public class Main {

    public static void main(String[] args) {

        DeliveryService cloud = new CloudDeliveryService();
        DeliveryService email = new EmailDeliveryService();

        PhotoDelivery single =
                new SinglePhotoDelivery(cloud);

        PhotoDelivery album =
                new AlbumDelivery(email);

        single.send("PHOTO-101", "Aida");
        album.send("2026", "Assiya");


        DeliveryService legacy =
                new LegacyDeliveryAdapter(new LegacyPhotoService());

        PhotoDelivery oldPhoto =
                new SinglePhotoDelivery(legacy);

        oldPhoto.send("OLD-001", "Aida");


        DeliveryService selectedService =
                DeliveryServiceSelector.select(args.length > 0 ? args[0] : "legacy");

        PhotoDelivery selectedDelivery =
                new AlbumDelivery(selectedService);

        selectedDelivery.send("OLD-2026", "Aida");
    }
}
