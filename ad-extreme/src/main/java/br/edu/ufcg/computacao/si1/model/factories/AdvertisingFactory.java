package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;

/**
 * Created by matth on 16/03/2017.
 */
public class AdvertisingFactory {
<<<<<<< HEAD

    private AdvertisingFactory() {
    }

=======
>>>>>>> 8ce5135e42b5b6c377978d2dd36e3be9f296152b
    public static Advertising createNewAdvertising(Long ownerId, String title, Double price, String adType) {
        AdvertisingType advertisingType = AdvertisingType.getType(adType);
        return new Advertising(ownerId, title, price, advertisingType);
    }
}
