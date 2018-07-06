package br.manytomany;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pus_problema_usuario")
public class ProblemaUsuario implements Serializable {

    private static final long serialVersionUID = -3909604748191603361L;

    @Id
    @GeneratedValue
    @Column(name = "pus_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", foreignKey = @ForeignKey(name = "fk_pus_usr_id"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "atn_id", referencedColumnName = "atn_id", foreignKey = @ForeignKey(name = "fk_pus_atn_id"))
    private Atendimento atendimento;

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

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final ProblemaUsuario other = (ProblemaUsuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
