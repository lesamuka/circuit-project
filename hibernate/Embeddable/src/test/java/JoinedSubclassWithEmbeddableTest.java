
import br.exemplo1.embeddable.ServiceBook;
import br.exemplo1.entity.Carro;
import br.exemplo1.entity.RepairShop;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class JoinedSubclassWithEmbeddableTest {

    @Test
    public void hello() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateDB");
        EntityManager em = entityManagerFactory.createEntityManager();

        Carro carro = new Carro();
        carro.setModel("asasas");
        carro.setProducer("carro");
        

        ServiceBook serviceBook = new ServiceBook();
        serviceBook.setBookNumber("sdfsdf");
        serviceBook.setOwner(2312);
        
        
        RepairShop repairShop = new RepairShop();
        repairShop.setNome("34234");
        serviceBook.setRepairShop(repairShop);
        
     //   carro.setServiceBook(serviceBook);

        em.getTransaction().begin();
        em.persist(carro);
        em.persist(repairShop);
        em.getTransaction().commit();
        
        List<Carro> resultList = em.createNativeQuery("select * from hibernate_db.car_carro", Carro.class).getResultList();

        System.out.println("aaa");
    }

}
