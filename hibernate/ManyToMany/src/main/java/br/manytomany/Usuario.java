package br.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usr_usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -7355508055514809681L;

    @Id
    @GeneratedValue
    @Column(name = "usr_id", nullable = false)
    private Integer id;

    @Column(name = "usr_nome")
    private String nome;

    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    private List<ProblemaUsuario> problemaUsuarioList = new ArrayList<>();

    public Usuario() {
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
