package br.edu.ufcg.computacao.si1.model.user;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by matth on 16/03/2017.
 */

public class PhysicalPerson implements PersonType {

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<PostPermission> postPermissionSet;

    public PhysicalPerson() {
        this.postPermissionSet = new HashSet<>();
    }


    @Override
    public boolean hasPermission(PostPermission postPermission) {
        return postPermissionSet.contains(postPermission);
    }

    @Override
    public String toString() {
        return "USER";
    }
}
