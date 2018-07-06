/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.exemplo2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author alci
 */
public class MainTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateDB");

        /* Create EntityManager */
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Address address = new Address();
        address.setArea("Pimple Saudagar");
        address.setPincode("411 027");

        Office office = new Office();
        office.setAddress(address);

        em.persist(office);

        transaction.commit();
    }
}
