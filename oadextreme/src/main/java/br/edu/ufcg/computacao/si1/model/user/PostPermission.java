package br.edu.ufcg.computacao.si1.model.user;

/**
 * Created by matth on 16/03/2017.
 */
public enum PostPermission {
    POST_JOB, POST_SERVICE, POST_BUILDS, POST_FURNITURE;

    @Override
    public String toString() {
        switch (this) {
            case POST_BUILDS:return "Builds";
            case POST_FURNITURE:return "Furniture";
            case POST_JOB:return "Jobs";
            case POST_SERVICE:return "Services";
            default:return "Nothing to show";
        }
    }
}
