package br.edu.ufcg.computacao.si1.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * Created by matth on 16/03/2017.
 */
public class User{
    private Long id;
    private String name;
    private String email;
    private String password;
    private PersonType personType;

    public User(String name, String email, String password, PersonType personType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.personType = personType;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
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

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
