//package br.heranca.model;
//
//import java.io.Serializable;
//import java.util.Objects;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "cad_cadastro")
//public class Cadastro extends AbstractEntidade implements Serializable {
//
//    private static final long serialVersionUID = -4766848889267506485L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cad_id", nullable = false)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "pss_id", referencedColumnName = "pss_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cad_pss_id"))
//    private Pessoa pessoa;
//
//    @Override
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Pessoa getPessoa() {
//        return pessoa;
//    }
//
//    public void setPessoa(Pessoa pessoa) {
//        this.pessoa = pessoa;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 97 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Cadastro other = (Cadastro) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }    
//}
