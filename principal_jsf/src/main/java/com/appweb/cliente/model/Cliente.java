package com.appweb.cliente.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

//@Entity
//@Table(name = "cln_cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = -7735396802585172567L;

//    @Id
//    @GeneratedValue
//    @Column(name = "cln_id", nullable = false)
    private Integer id;

//    @Column(name = "cln_cliente", scale = 100, nullable = false)
    private String cliente;

//    @Column(name = "cln_endereco", scale = 50, nullable = false)
    private String endereco;

//    @Column(name = "cln_telefone", scale = 20, nullable = false)
    private String telefone;

//    @Column(name = "cln_email", scale = 30, nullable = false)
    private String email;

//    @OneToMany(mappedBy = "cliente", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ContatoRealizado> contatoRealizadoList = new ArrayList<>();

    public Cliente() {
    }

    public void adicionar(ContatoRealizado contatoRealizado) {
        contatoRealizado.setCliente(this);
        contatoRealizadoList.add(contatoRealizado);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContatoRealizado> getContatoRealizadoList() {
        return contatoRealizadoList;
    }

    public void setContatoRealizadoList(List<ContatoRealizado> contatoRealizadoList) {
        this.contatoRealizadoList = contatoRealizadoList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
