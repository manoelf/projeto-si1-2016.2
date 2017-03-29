package br.edu.ufcg.computacao.si1.model.repositories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by matth on 16/03/2017.
 */
@Repository
public interface AdvertisingRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> getByOwnerId(Long ownerId);
//    List<Advertisement> getByType(AdvertisementType advertisingType);
    //21db7ca795
}
