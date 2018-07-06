package br.com.s3service;

import com.amazonaws.regions.Regions;

//http://docs.aws.amazon.com/general/latest/gr/rande.html
public enum Regiao {

    US_WEST_OREGON("US West (Oregon)", Regions.SA_EAST_1),
    SOUTH_AMERICA_SAO_PAULO("South America (São Paulo)", Regions.SA_EAST_1);

    private String regiao;
    private Regions regions;

    private Regiao(String regiao, Regions regions) {
        this.regiao = regiao;
        this.regions = regions;
    }

    public String getRegiao() {
        return regiao;
    }

    public Regions getRegions() {
        return regions;
    }
}
