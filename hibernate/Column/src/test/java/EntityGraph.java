/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alci
 */
public class EntityGraph {
    
//    
//    EntityGraph<TableTypeViw> createEntityGraph = em.createEntityGraph(TableTypeViw.class);
//
//    List<TableTypeViw> resultList1 = em.createQuery("select p from Post p where p.id=:id", TableTypeViw.class)
//            .setHint("javax.persistence.fetchgraph", createEntityGraph)
//            .getResultList();
    
//EntityGraph<EmailMessage> eg = em.createEntityGraph(EmailMessage.class);
//eg.addAttributeNodes("body");
//Properties props = new Properties();
//props.put("javax.persistence.fetchgraph", eg);
//EmailMessage message = em.find(EmailMessage.class, id, props);
    
//    Properties props = new Properties();
//    props.put("javax.persistence.loadgraph", includeOtherGraph);
//    MyClass myObj = em.find(MyClass.class, id, props);
    
    //https://blog.jooq.org/2016/06/28/turn-around-dont-use-jpas-loadgraph-and-fetchgraph-hints-use-sql-instead/
}
