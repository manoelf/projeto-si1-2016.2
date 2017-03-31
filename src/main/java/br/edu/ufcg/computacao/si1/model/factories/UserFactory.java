package br.edu.ufcg.computacao.si1.model.factories;

import br.edu.ufcg.computacao.si1.model.forms.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;

/**
 * Created by matth on 16/03/2017.
 */
public class UserFactory {

    private static UserFactoryMethod userFactoryMethod;

    public static User createNewUser(String name, String email, String password, String personType){
        if (personType.equalsIgnoreCase("PhysicalPerson")){
            userFactoryMethod = new PhysicalPersonFactory();
        }else{
            userFactoryMethod =  new LegalPersonFactory();
        }
        return userFactoryMethod.createUser(name, email, password);
    }

    public static User createNewUser(UserForm userForm) {
        System.out.println(userForm);
        String userName = userForm.getName();
        String userEmail = userForm.getEmail();
        String userPassword = userForm.getPassword();
        String userPersonType = userForm.getPersonType();


        return createNewUser(userName, userEmail, userPassword, userPersonType);
    }

}
