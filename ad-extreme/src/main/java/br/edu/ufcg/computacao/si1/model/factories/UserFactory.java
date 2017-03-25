package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.forms.UserForm;
import br.edu.ufcg.computacao.si1.model.user.LegalPerson;
import br.edu.ufcg.computacao.si1.model.user.PersonType;
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

    public static User createNewUser(UserForm userForm) {
        System.out.println(userForm);
        String userName = userForm.getName();
        String userEmail = userForm.getEmail();
        String userPassword = userForm.getPassword();
        String userPersonType = userForm.getPersonType();

        if (userPersonType.equalsIgnoreCase("physicalPerson")) {
            return new User(userName, userEmail, userPassword, new PhysicalPerson());
        }else {
            return new User(userName, userEmail, userPassword, new LegalPerson());
        }
    }

}
