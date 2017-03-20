package br.edu.ufcg.computacao.si1.model.advertising;

import javax.persistence.*;

/**
 * Created by matth on 16/03/2017.
 */
@Entity
@Table(name="advertisement_tb")
public class Advertising {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ownerId", nullable = false)
    private Long ownerId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "creationDate", nullable = false)
    private String creationDate;

    @Column(name = "price", nullable = false)
    private Double price;

//    @Column(name = "advertisingType", nullable = false)
//    private AdvertisingType advertisingType;

    public Advertising() {
    }

    public Advertising(Long ownerId, String title, Double price, AdvertisingType advertisingType) {
        this.ownerId = ownerId;
        this.title = title;
        this.creationDate = "TODAY"; //TODO
        this.price = price;

//        this.advertisingType = advertisingType;
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

//    public AdvertisingType getAdvertisingType() {
//        return advertisingType;
//    }
//
//    public void setAdvertisingType(AdvertisingType advertisingType) {
//        this.advertisingType = advertisingType;
//    }


}
