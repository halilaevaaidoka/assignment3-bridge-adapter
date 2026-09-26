
package kz.aida.photography;

import kz.aida.photography.selection.DeliveryServiceSelector;
import kz.aida.photography.adapter.LegacyDeliveryAdapter;
import org.junit.jupiter.api.Test;
import kz.aida.photography.implementor.DeliveryService;
import kz.aida.photography.implementor.CloudDeliveryService;
import kz.aida.photography.implementor.EmailDeliveryService;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceSelectorTest {

    @Test
    void selectsCloud() {
        assertInstanceOf(
                CloudDeliveryService.class,
                DeliveryServiceSelector.select("cloud")
        );
    }

    @Test
    void selectsEmail() {
        assertInstanceOf(
                EmailDeliveryService.class,
                DeliveryServiceSelector.select("email")
        );
    }

    @Test
    void selectsLegacyAdapter() {
        assertInstanceOf(
                LegacyDeliveryAdapter.class,
                DeliveryServiceSelector.select("legacy")
        );
    }

    @Test
    void rejectsUnknownType() {
        assertThrows(
                IllegalArgumentException.class,
                () -> DeliveryServiceSelector.select("unknown")
        );
    }
}
