package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.user.PhysicalPerson;
import br.edu.ufcg.computacao.si1.model.user.User;

/**
 * Created by manoel on 27/03/17.
 */
public class LegalPersonFactory extends UserFactoryMethod {

    @Override
    public User createUser(String name, String email, String password) {
        return new User(name, email, password, new PhysicalPerson());
    }

}
