package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;
import br.edu.ufcg.computacao.si1.model.forms.AdvertisingForm;

/**
 * Created by matth on 16/03/2017.
 */
public class AdvertisingFactory {

    private AdvertisingFactory() {
    }

    public static Advertising createNewAdvertising(Long ownerId, String title, Double price, String adType) {
        AdvertisingType advertisingType = AdvertisingType.getType(adType);
        return new Advertising(ownerId, title, price, advertisingType);
    }

    public static Advertising createNewAdvertising(AdvertisingForm advertisingForm) {
        Long ownerId = advertisingForm.getOwnerId();
        String title = advertisingForm.getTitle();
        Double price = advertisingForm.getPrice();
        String type = advertisingForm.getType();
        AdvertisingType advertisingType = AdvertisingType.getType(type);
        Advertising advertising = new Advertising(ownerId, title, price, advertisingType);
        return advertising;
    }
}
