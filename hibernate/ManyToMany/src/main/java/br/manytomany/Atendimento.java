package br.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atn_atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = -7355508055514809681L;

    @Id
    @GeneratedValue
    @Column(name = "atn_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", foreignKey = @ForeignKey(name = "fk_atn_usr_id"))
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "apu_atendimento_problema_usuario",
            joinColumns = {
                @JoinColumn(name = "atn_id", referencedColumnName = "atn_id", foreignKey = @ForeignKey(name = "fk_apu_atn_id"))},
            inverseJoinColumns = {
                @JoinColumn(name = "pus_id", referencedColumnName = "pus_id", foreignKey = @ForeignKey(name = "fk_apu_pus_id"))})
    private List<ProblemaUsuario> problemaUsuarioList = new ArrayList<>();

    public Atendimento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ProblemaUsuario> getProblemaUsuarioList() {
        return problemaUsuarioList;
    }

    public void setProblemaUsuarioList(List<ProblemaUsuario> problemaUsuarioList) {
        this.problemaUsuarioList = problemaUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
