package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;

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
}
