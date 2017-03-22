package br.edu.ufcg.computacao.si1.model.advertising;

/**
 * Created by matth on 16/03/2017.
 */
public enum AdvertisingType {
    JOB, SERVICE, BUILD, FURNITURE;

    public static AdvertisingType getType(String type) {
        switch (type.toUpperCase()) {
            case "JOB":
                return JOB;
            case "SERVICE":
                return SERVICE;
            case "BUILD":
                return BUILD;
            case "FURNITURE":
                return FURNITURE;
            default:
                throw new RuntimeException("'" + type + "' Advertising type does not exists");
        }
    }
}
