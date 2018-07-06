package com.appweb.cliente.dao;

import com.appweb.cliente.model.Cliente;
import java.io.Serializable;
import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

public class ClienteDao implements Serializable{

    private static final long serialVersionUID = -6466989861698789586L;
//    private static EntityManager em;

     static {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateDB");
//        em = factory.createEntityManager();
    }

    public static void salvar(Cliente cliente) {
//        em.getTransaction().begin();
//        em.persist(cliente);
//        em.getTransaction().commit();
    }

    public static Cliente alterar(Cliente cliente) {
//        em.getTransaction().begin();
//        cliente = em.merge(cliente);
//        em.getTransaction().commit();
        return cliente;
    }

    public static void excluir(Cliente cliente) {
//        em.getTransaction().begin();
//        em.remove(cliente);
//        em.getTransaction().commit();
    }

    public static List<Cliente> listar() {
//        return em.createQuery("select cli from Cliente cli order by cli.cliente desc", Cliente.class).getResultList();
        return null;
    }
}
