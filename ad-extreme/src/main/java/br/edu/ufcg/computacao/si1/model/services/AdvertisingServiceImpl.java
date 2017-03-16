package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;
import br.edu.ufcg.computacao.si1.model.factories.AdvertisingFactory;
import br.edu.ufcg.computacao.si1.model.repositories.AdvertisingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by matth on 16/03/2017.
 */
@Service
public class AdvertisingServiceImpl implements AdvertisingService{
    @Autowired
    private AdvertisingRepository advertisingRepository;


    @Override
    public Advertising getById(Long id) {
        return this.advertisingRepository.findOne(id);
    }

    @Override
    public Set<Advertising> getByOwnerId(Long ownerId) {
        return this.advertisingRepository.getByOwnerID(ownerId);
    }

    @Override
    public void create(String adType, Long ownerId) {
        AdvertisingFactory.createNewAdvertising(adType, ownerId);

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Advertising advertising) {

    }

    @Override
    public Set<Advertising> getAll() {
        return null;
    }
}
