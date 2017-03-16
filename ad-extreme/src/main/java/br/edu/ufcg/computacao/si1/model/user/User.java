package br.edu.ufcg.computacao.si1.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * Created by matth on 16/03/2017.
 */
public class User extends org.springframework.security.core.userdetails.User{
    private Long id;
    private String name;
    private String email;
    private PersonType personType;

    public User() {
        super("", "", AuthorityUtils.createAuthorityList("USER"));

    }



}
