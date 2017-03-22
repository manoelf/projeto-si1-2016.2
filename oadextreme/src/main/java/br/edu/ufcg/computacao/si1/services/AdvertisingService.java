package br.edu.ufcg.computacao.si1.services;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;

import java.util.List;

/**
 * Created by matth on 16/03/2017.
 */
public interface AdvertisingService {

    public void add(Advertising advertising) ;

    public Advertising getById(Long id);
    public List<Advertising> getByOwnerId(Long ownerId);

    public void create(Long ownerId, String title, Double price, String adType);
    public void delete(Long id);
    public void update(Advertising advertising);

    public List<Advertising> getAll();


    List<Advertising> getByType(AdvertisingType advertisingType);
}
