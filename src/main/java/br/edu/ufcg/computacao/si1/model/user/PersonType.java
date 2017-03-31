package br.edu.ufcg.computacao.si1.model.user;

import javax.persistence.Embeddable;

/**
 * Created by matth on 16/03/2017.
 */
@Embeddable
public interface PersonType {

    public boolean hasPermission(PostPermission postPermission);
}
