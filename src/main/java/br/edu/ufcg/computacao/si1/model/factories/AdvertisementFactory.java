package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertisement;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisementType;
import br.edu.ufcg.computacao.si1.model.forms.AdvertisementForm;

/**
 * Created by matth on 16/03/2017.
 */
public class AdvertisementFactory {

    private AdvertisementFactory() {
    }

    public static Advertisement createNewAdvertising(Long ownerId, String title, Double price, String adType) {
        AdvertisementType advertisementType = AdvertisementType.getType(adType);
        return new Advertisement(ownerId, title, price, advertisementType);
    }

    public static Advertisement createNewAdvertising(AdvertisementForm advertisementForm) {
//        Long ownerId = advertisementForm.getOwnerId(); TODO
        String title = advertisementForm.getTitle();
        Double price = advertisementForm.getPrice();
        String type = advertisementForm.getType();
        AdvertisementType advertisementType = AdvertisementType.getType(type);
        Advertisement advertisement = new Advertisement(1l, title, price, advertisementType);//TODO
        return advertisement;
    }
}
