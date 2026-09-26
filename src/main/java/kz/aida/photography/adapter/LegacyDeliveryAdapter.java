package kz.aida.photography.adapter;

import kz.aida.photography.implementor.DeliveryService;
import kz.aida.photography.legacy.LegacyPhotoService;

public class LegacyDeliveryAdapter implements DeliveryService {

    private final LegacyPhotoService legacyService;

    public LegacyDeliveryAdapter(LegacyPhotoService legacyService) {
        this.legacyService = legacyService;
    }

    @Override
    public void deliver(String photoId, String recipient) {


        int photoNumber;

        try {

            String number = photoId.replace("ALBUM-", "")
                    .replace("OLD-", "");
            photoNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Invalid legacy photo ID: " + photoId, e
            );
        }


        int result = legacyService.sendOldPhoto(
                recipient, photoNumber
        );

        if (result != 0) {
            throw new IllegalStateException(
                    "Legacy photo delivery failed"
            );
        }
    }
}
