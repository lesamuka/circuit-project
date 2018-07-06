package br.core.util;

public enum TipoConexaoEnum {

    MYSQL("persistence_unit_mysql"),
    POSTGRES("persistence_unit_postgres");

    private String persistenceUnit;

    private TipoConexaoEnum(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    public String getPersistenceUnit() {
        return persistenceUnit;
    }

    public void setPersistenceUnit(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }
}
