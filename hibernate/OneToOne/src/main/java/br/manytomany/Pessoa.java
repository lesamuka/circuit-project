package br.manytomany;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pss_pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = -7355508055514809681L;

    @Id
    @GeneratedValue
    @Column(name = "pss_id", nullable = false)
    private Integer id;

    @Column(name = "pss_nome", unique = true, nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Endereco.class)
    @JoinColumn(name = "end_id", unique = true, referencedColumnName = "end_id")
    private Endereco endereco;

    public Pessoa() {
    }

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
