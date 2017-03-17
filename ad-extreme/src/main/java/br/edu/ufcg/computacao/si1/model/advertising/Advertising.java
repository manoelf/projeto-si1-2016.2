package br.edu.ufcg.computacao.si1.model.advertising;

/**
 * Created by matth on 16/03/2017.
 */
public class Advertising {
    private Long id;
    private Long ownerId;

    private String title;
    private String creationDate;
    private Double price;

    private AdvertisingType advertisingType;


    public Advertising(Long ownerId, String title, Double price, AdvertisingType type) {
        this.ownerId = ownerId;
        this.title = title;
        this.creationDate = "TODAY"; //TODO
        this.price = price;

        this.advertisingType = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AdvertisingType getAdvertisingType() {
        return advertisingType;
    }

    public void setAdvertisingType(AdvertisingType advertisingType) {
        this.advertisingType = advertisingType;
    }
}
