package br.edu.ufcg.computacao.si1.repositories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by matth on 16/03/2017.
 */
@Repository
public interface AdvertisingRepository extends JpaRepository<Advertising, Long> {
    List<Advertising> getByOwnerId(Long ownerId);
//    List<Advertising> getByType(AdvertisingType advertisingType);
    //21db7ca795
}
