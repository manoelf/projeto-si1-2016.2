package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.advertising.Advertisement;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisementType;

import java.util.List;

/**
 * Created by matth on 16/03/2017.
 */
public interface AdvertisementService {

    public void add(Advertisement advertisement) ;

    public Advertisement getById(Long id);
    public List<Advertisement> getByOwnerId(Long ownerId);

    public void create(Long ownerId, String title, Double price, String adType);
    public void delete(Long id);
    public void update(Advertisement advertisement);

    public List<Advertisement> getAll();


    List<Advertisement> getByType(AdvertisementType advertisementType);

    public void deleteAll();
}
