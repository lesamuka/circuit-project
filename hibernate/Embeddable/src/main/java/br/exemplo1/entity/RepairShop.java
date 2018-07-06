package br.exemplo1.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rps_repair_shop")
public class RepairShop implements Serializable {

    private static final long serialVersionUID = -8726433837186780648L;

    @Id
    @GeneratedValue
    @Column(name = "rps_id", nullable = false)
    private Integer id;

    @Column(name = "rps_nome", nullable = false)
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
