package br.edu.ufcg.computacao.si1.model.user;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matth on 16/03/2017.
 */
public class LegalPerson implements PersonType {

    private Set<Permissions> permissionsSet;

    public LegalPerson() {
        this.permissionsSet = new HashSet<>();
    }


    @Override
    public boolean hasPermission(Permissions permission) {
        return permissionsSet.contains(permission);
    }
}
