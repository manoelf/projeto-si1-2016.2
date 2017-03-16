package br.edu.ufcg.computacao.si1.model.repositories;

import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by matth on 16/03/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
