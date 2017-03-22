package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.user.LegalPerson;
import br.edu.ufcg.computacao.si1.model.user.PhysicalPerson;
import br.edu.ufcg.computacao.si1.model.user.User;

/**
 * Created by matth on 16/03/2017.
 */
public class UserFactory {

    public static User createNewUser(String name, String email, String password, String personType){
        if (personType.equalsIgnoreCase("PhysicalPerson")){

            return new User(name, email, password, new PhysicalPerson());
        }else{
            return new User(name, email, password, new LegalPerson());
        }


    }

}
