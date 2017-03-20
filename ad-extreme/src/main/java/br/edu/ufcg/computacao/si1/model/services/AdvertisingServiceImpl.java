package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisingType;
import br.edu.ufcg.computacao.si1.model.factories.AdvertisingFactory;
import br.edu.ufcg.computacao.si1.model.repositories.AdvertisingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by matth on 16/03/2017.
 */
@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingRepository advertisingRepository;

    @Override
    public void add(Advertising advertising) {
        save(advertising);
    }

    @Override
    public Advertising getById(Long id) {
        return this.advertisingRepository.findOne(id);
    }

    @Override
    public List<Advertising> getByOwnerId(Long ownerId) {
        return this.advertisingRepository.getByOwnerID(ownerId);
    }

    @Override
    public void create(Long ownerId, String title, Double price, String adType) {
        Advertising newAd = AdvertisingFactory.createNewAdvertising(ownerId, title, price, adType);
        this.advertisingRepository.save(newAd);
    }

    @Override
    public void delete(Long id) {
        this.advertisingRepository.delete(id);
    }

    private void save(Advertising advertising) {
        this.advertisingRepository.save(advertising);
    }

    @Override
    public void update(Advertising advertising) {
        this.advertisingRepository.delete(advertising.getId());
        save(advertising);
    }

    @Override
    public List<Advertising> getAll() {
        return this.advertisingRepository.findAll();
    }

    @Override
    public List<Advertising> getByType(AdvertisingType advertisingType) {
        return this.advertisingRepository.getByType(advertisingType);
    }
}
