package br.edu.ufcg.computacao.si1.model.advertising;

/**
 * Created by matth on 16/03/2017.
 */
public class Advertising {
    private Long id;
    private Long ownerId;
    private AdvertisingType advertisingType;

    public Advertising(AdvertisingType type, Long ownerId) {
        this.ownerId = ownerId;
        this.advertisingType = type;
    }

    //temp
    public void register() {
        //do something
        //do more
    }


}
