//package br.heranca.model;
//
//import java.io.Serializable;
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
//@Table(name = "odm_ordem")
//public class Ordem implements Serializable {
//
//    private static final long serialVersionUID = 2249850348663627403L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "odm_id", nullable = false)
//    protected Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "pss_id", referencedColumnName = "pss_id", nullable = false, foreignKey = @ForeignKey(name = "fk_odm_pss_id"))
//    private PessoaJuridica pessoaJuridica;
//
//    @Column(name = "odm_nome", nullable = false)
//    private String descricao;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public PessoaJuridica getPessoaJuridica() {
//        return pessoaJuridica;
//    }
//
//    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
//        this.pessoaJuridica = pessoaJuridica;
//    }
//    
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//}
