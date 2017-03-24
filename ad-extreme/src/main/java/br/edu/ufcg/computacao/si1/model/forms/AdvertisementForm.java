package br.edu.ufcg.computacao.si1.model.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by gersonsales on 16/03/17.
 */
public class AdvertisementForm {
//    private Long ownerId;

    @NotNull(message = "O titulo não pode ser nulo.")
    @NotEmpty(message = "O titulo não pode esta vazio.")
    @Size(min = 10, max = 100, message = "O titulo deve ter entre 2 e 100 caracters")
    private String title;

    @NotNull(message = "O preçço não pode ser nulo.")
    @DecimalMin(value = "0.1", message = "O preço minimo é 0.1 para um anúncio.")
    private Double price;

//    private String type; //TODO

//
//    public Long getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(Long ownerId) {
//        this.ownerId = ownerId;
//    }

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

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }


    @Override
    public String toString() {
        return "AdvertisementForm{" +
//                "ownerId=" + ownerId + TODO
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
