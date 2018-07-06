package com.list.stream;

import java.util.List;
import java.util.function.Predicate;

public class Pessoa implements Entidade //, Predicate<Pessoa> 
{

    private static final long serialVersionUID = -8487274034927037828L;

    private Integer id;
    private String nome;
    private int idade;
    private SexoEnum sex;
    private List<Contato> contatoList;

    public Pessoa(Integer id, String nome, int indade, SexoEnum sex) {
        this.id = id;
        this.nome = nome;
        this.idade = indade;
        this.sex = sex;
    }

    public Pessoa(Integer id, String nome, int indade, SexoEnum sex, List<Contato> contatoList) {
        this.id = id;
        this.nome = nome;
        this.idade = indade;
        this.sex = sex;
        this.contatoList = contatoList;
    }

    public Pessoa(String nome, int indade) {
        this.nome = nome;
        this.idade = indade;
    }

    public Pessoa(String nome, int indade, SexoEnum sex) {
        this.id = id;
        this.nome = nome;
        this.idade = indade;
        this.sex = sex;
    }

    public Pessoa(int indade, SexoEnum sex) {
        this.idade = indade;
        this.sex = sex;
    }

    public static Predicate<Pessoa> isAdultMale() {
        return u -> u.getIdade() >= 18 && u.getSex().equals(SexoEnum.MALE);
    }

    @Override
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public SexoEnum getSex() {
        return sex;
    }

    public void setSex(SexoEnum sex) {
        this.sex = sex;
    }

    public List<Contato> getContatoList() {
        return contatoList;
    }

    public void setContatoList(List<Contato> contatoList) {
        this.contatoList = contatoList;
    }
    
    @Override
    public String toString() {
        return id + " " + nome + " " + idade + " " + sex;
    }

//    @Override
//    public boolean test(Pessoa pessoa) {
//        return pessoa.getIdade() > 21 && pessoa.getSex() == SexoEnum.MALE;
//    }
}
