package br.edu.ufcg.computacao.si1.model.services;

import br.edu.ufcg.computacao.si1.model.forms.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matth on 16/03/2017.
 */
public interface UserService {
    public User getById (Long id);

    public void create (String name, String email, String password, String personType);
    public void delete (Long id);
    public void update (User user);
    public List<User> getAll();
    public boolean containsUserEmail(String email);

}
