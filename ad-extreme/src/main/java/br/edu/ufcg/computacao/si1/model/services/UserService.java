package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.user.PersonType;
import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by matth on 16/03/2017.
 */
@Service
public interface UserService {
    public User getById (Long id);

    public void create (String name, String email, String senha, PersonType personType);
    public void delete (Long id);
    public void update (User user);

    public Set<User> getAll();

}
