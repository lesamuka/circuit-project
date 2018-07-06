package br.manytomany;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "end_endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = -3909604748191603361L;

    @Id
    @GeneratedValue
    @Column(name = "end_id", nullable = false)
    private Integer id;

    @Column(name = "end_descricao", unique = true, nullable = false)
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
