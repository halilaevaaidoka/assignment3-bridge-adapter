package kz.aida.photography.selection;

import kz.aida.photography.adapter.LegacyDeliveryAdapter;
import kz.aida.photography.legacy.LegacyPhotoService;
import kz.aida.photography.implementor.DeliveryService;
import kz.aida.photography.implementor.CloudDeliveryService;
import kz.aida.photography.implementor.EmailDeliveryService;

public class DeliveryServiceSelector {

    public static DeliveryService select(String deliveryType) {

        if (deliveryType == null) {
            throw new IllegalArgumentException("Delivery type cannot be null");
        }

        return switch (deliveryType.toLowerCase()) {
            case "cloud" -> new CloudDeliveryService();
            case "email" -> new EmailDeliveryService();
            case "legacy" -> new LegacyDeliveryAdapter(
                    new LegacyPhotoService()
            );
            default -> throw new IllegalArgumentException(
                    "Unknown delivery type: " + deliveryType
            );
        };
    }
}
