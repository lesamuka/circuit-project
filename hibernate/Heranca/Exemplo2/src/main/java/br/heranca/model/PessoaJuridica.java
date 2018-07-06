package br.heranca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "psj_pessoa_juridica")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name = "pss_id", referencedColumnName = "pss_id", foreignKey = @ForeignKey(name = "fk_psj_pss_id"))})
public class PessoaJuridica extends Pessoa {

    private static final long serialVersionUID = -6172127294759514438L;

    @Column(name = "psj_cnpj", nullable = false)
    private String cnpj;

//    @OneToMany(mappedBy = "pessoaJuridica", orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<Ordem> ordemList = new ArrayList<>();
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

//    public List<Ordem> getOrdemList() {
//        return ordemList;
//    }
//
//    public void setOrdemList(List<Ordem> ordemList) {
//        this.ordemList = ordemList;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cnpj);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }
}
