package br.edu.ufcg.computacao.si1.model.forms;

/**
 * Created by gersonsales on 16/03/17.
 */
public class AdvertisingForm {
    private Long ownerId;
    private String title;
    private Double price;
    private String type; //TODO


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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
