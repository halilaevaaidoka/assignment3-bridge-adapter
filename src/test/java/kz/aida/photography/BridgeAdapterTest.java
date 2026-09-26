
package kz.aida.photography;

import kz.aida.photography.abstraction.*;
import kz.aida.photography.adapter.LegacyDeliveryAdapter;
import kz.aida.photography.legacy.LegacyPhotoService;
import org.junit.jupiter.api.Test;
import kz.aida.photography.implementor.DeliveryService;
import kz.aida.photography.implementor.CloudDeliveryService;
import kz.aida.photography.implementor.EmailDeliveryService;

import static org.junit.jupiter.api.Assertions.*;

class BridgeAdapterTest {

    @Test
    void singlePhotoWorksWithCloud() {
        DeliveryService service = new CloudDeliveryService();
        PhotoDelivery delivery = new SinglePhotoDelivery(service);

        assertDoesNotThrow(
                () -> delivery.send("PHOTO-101", "Aida")
        );
    }

    @Test
    void albumWorksWithEmail() {
        DeliveryService service = new EmailDeliveryService();
        PhotoDelivery delivery = new AlbumDelivery(service);

        assertDoesNotThrow(
                () -> delivery.send("2026", "Assiya")
        );
    }

    @Test
    void bridgeWorksWithLegacyAdapter() {
        DeliveryService service =
                new LegacyDeliveryAdapter(new LegacyPhotoService());

        PhotoDelivery delivery = new SinglePhotoDelivery(service);

        assertDoesNotThrow(
                () -> delivery.send("OLD-001", "Aida")
        );
    }

    @Test
    void invalidPhotoIdThrowsException() {
        DeliveryService adapter =
                new LegacyDeliveryAdapter(new LegacyPhotoService());

        assertThrows(
                IllegalArgumentException.class,
                () -> adapter.deliver("INVALID", "Aida")
        );
    }

    @Test
    void legacyErrorCodeIsTranslated() {
        DeliveryService adapter =
                new LegacyDeliveryAdapter(new LegacyPhotoService());

        assertThrows(
                IllegalStateException.class,
                () -> adapter.deliver("OLD-0", "Aida")
        );
    }

    @Test
    void singlePhotoDelegatesToStub() {
        StringBuilder received = new StringBuilder();

        DeliveryService stub = (photoId, recipient) ->
                received.append(photoId).append(":").append(recipient);

        PhotoDelivery delivery = new SinglePhotoDelivery(stub);
        delivery.send("PHOTO-101", "Aida");

        assertEquals("PHOTO-101:Aida", received.toString());
    }

    @Test
    void albumDelegatesToStub() {
        StringBuilder received = new StringBuilder();

        DeliveryService stub = (photoId, recipient) ->
                received.append(photoId).append(":").append(recipient);

        PhotoDelivery delivery = new AlbumDelivery(stub);
        delivery.send("2026", "Assiya");

        assertEquals("ALBUM-2026:Assiya", received.toString());
    }


}
