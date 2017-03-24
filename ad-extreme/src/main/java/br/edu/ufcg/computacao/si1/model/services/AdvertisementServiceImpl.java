package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.advertising.Advertisement;
import br.edu.ufcg.computacao.si1.model.advertising.AdvertisementType;
import br.edu.ufcg.computacao.si1.model.factories.AdvertisementFactory;
import br.edu.ufcg.computacao.si1.model.repositories.AdvertisingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by matth on 16/03/2017.
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    public AdvertisementServiceImpl() {
    }

    @Autowired
    private AdvertisingRepository advertisingRepository;

    @Override
    public void add(Advertisement advertisement) {
        save(advertisement);
    }

    @Override
    public Advertisement getById(Long id) {
        return this.advertisingRepository.findOne(id);
    }

    @Override
    public List<Advertisement> getByOwnerId(Long ownerId) {
        return this.advertisingRepository.getByOwnerId(ownerId);
    }

    @Override
    public void create(Long ownerId, String title, Double price, String adType) {
        Advertisement newAd = AdvertisementFactory.createNewAdvertising(ownerId, title, price, adType);
        this.advertisingRepository.save(newAd);
    }

    @Override
    public void delete(Long id) {
        this.advertisingRepository.delete(id);
    }

    private void save(Advertisement advertisement) {
        this.advertisingRepository.save(advertisement);
    }

    @Override
    public void update(Advertisement advertisement) {
        this.advertisingRepository.delete(advertisement.getId());
        save(advertisement);
    }

    @Override
    public List<Advertisement> getAll() {
        return this.advertisingRepository.findAll();
    }

    @Override
    public List<Advertisement> getByType(AdvertisementType advertisementType) {
//        return this.advertisingRepository.getByType(advertisementType);
        return null;
    }

    @Override
    public void deleteAll() {
        for (Advertisement advertisement : getAll()) {
            delete(advertisement.getId());//TODO a lambda expression
        }
    }
}
