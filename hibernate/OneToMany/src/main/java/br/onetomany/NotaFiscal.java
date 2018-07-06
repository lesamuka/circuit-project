package br.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nfs_nota_fiscal")
public class NotaFiscal implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "nfs_id", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "nfs_numero_nota", nullable = false)
    private Integer numeroNota;
    
    @OneToMany(mappedBy = "notaFiscal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Produto> produtoList = new ArrayList<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
}
