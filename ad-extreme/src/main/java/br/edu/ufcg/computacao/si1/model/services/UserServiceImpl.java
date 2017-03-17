package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.repositories.UserRepository;
import br.edu.ufcg.computacao.si1.model.user.PersonType;
import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by matth on 16/03/2017.
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepository userRepository;


    @Override
    public User getById(Long id) {
       return userRepository.findOne(id);

    }

    @Override
    public void create(String name, String email, String senha, PersonType personType) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public Set<User> getAll() {
        return null;
    }
}
