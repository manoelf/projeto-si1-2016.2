package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.user.User;

/**
 * Created by manoel on 27/03/17.
 */
public abstract class UserFactoryMethod {

    public abstract User createUser(String name, String email, String password);

}

