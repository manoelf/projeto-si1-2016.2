package br.edu.ufcg.computacao.si1.model.forms;

/**
 * Created by manoel on 16/03/17.
 */
public class UserForm {

    private String name;
    private String email;
    private String password;
    private String personType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }
}
