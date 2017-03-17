package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.factories.UserFactory;
import br.edu.ufcg.computacao.si1.model.repositories.UserRepository;
import br.edu.ufcg.computacao.si1.model.user.PersonType;
import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matth on 16/03/2017.
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public User getById(Long id) {
       return userRepository.findOne(id);

    }

    @Override
    public void create(String name, String email, String password, String personType) {
        UserFactory.createNewUser(name, email, password, personType);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);

    }

    @Override
    public void update(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();

    }
}
