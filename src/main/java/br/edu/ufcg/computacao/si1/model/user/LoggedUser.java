package br.edu.ufcg.computacao.si1.model.user;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gersonsales on 19/03/17.
 */
public class LoggedUser {

    private Set<PostPermission> postPostPermissions;

    public LoggedUser() {
        this.postPostPermissions = new HashSet<>();
    }

    public Set<PostPermission> getPostPermisions() {
        return postPostPermissions;
    }

    public void addPermission(PostPermission postPermission) {
        this.postPostPermissions.add(postPermission);
    }
}
