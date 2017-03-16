package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;

import java.util.Set;

/**
 * Created by matth on 16/03/2017.
 */
public interface AdvertisingService {

    public Advertising getById(Long id);
    public Set<Advertising> getByOwnerId(Long ownerId);

    public void create(String adType, Long ownerId);
    public void delete(Long id);
    public void update(Advertising advertising);

    public Set<Advertising> getAll();


}
