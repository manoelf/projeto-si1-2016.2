package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;

/**
 * Created by matth on 16/03/2017.
 */
public class AdvertisingFactory {
    public static Advertising createNewAdvertising(String adType, Long ownerId) {
        return new Advertising(AdvertisingType.getType(adType), ownerId);
    }
}
