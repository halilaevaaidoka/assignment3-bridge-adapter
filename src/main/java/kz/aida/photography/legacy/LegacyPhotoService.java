package kz.aida.photography.legacy;

public class LegacyPhotoService {

    public int sendOldPhoto(String recipient, int photoNumber) {

        if (photoNumber <= 0) {
            return -1;
        }

        System.out.println(
                "Legacy delivery: OLD-" + photoNumber
                        + " to " + recipient
        );

        return 0;
    }
}
