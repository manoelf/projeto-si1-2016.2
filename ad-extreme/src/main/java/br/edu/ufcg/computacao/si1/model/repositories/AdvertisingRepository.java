package br.edu.ufcg.computacao.si1.model.repositories;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by matth on 16/03/2017.
 */
@Repository
public interface AdvertisingRepository extends CrudRepository<Advertising, Long> {
    Set<Advertising> getByOwnerID(Long ownerId);
}
