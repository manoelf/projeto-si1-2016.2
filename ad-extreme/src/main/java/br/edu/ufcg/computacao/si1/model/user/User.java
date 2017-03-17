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



}
