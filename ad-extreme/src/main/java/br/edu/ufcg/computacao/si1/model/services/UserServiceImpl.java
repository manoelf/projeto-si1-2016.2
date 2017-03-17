package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.factories.UserFactory;
import br.edu.ufcg.computacao.si1.model.repositories.UserRepository;
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
        User newUser = UserFactory.createNewUser(name, email, password, personType);
        this.userRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.delete(id);

    }

    @Override
    public void update(User user) {
        delete(user.getId());
        this.userRepository.save(user);

    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();

    }

    @Override
    public boolean containsUserEmail(String email) {
        boolean result = false;
        for (User user: getAll()) {
            if (user.getEmail().equals(email)) {
                result = true;
            }
        }
        return result;
    }
}
