
import br.com.fk1.config.ConfiguraSpring;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

//@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration ({"classpath*:testApplicationContext.xml"}) //classpath*:META-INF
//@ContextConfiguration(locations = {"file:src/main/resources/META-INF/testApplicationContext.xml"})
@ContextConfiguration(classes = {ConfiguraSpring.class})
//@TransactionConfiguration(defaultRollback = false)

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath*:testApplicationContext.xml" })
//@TransactionConfiguration
////@WebAppConfiguration
//@Transactional
public class EntityManagerTest {

    @PersistenceContext(unitName = "SalutePU")
    protected EntityManager em;

    @Test
    public void init() {
        hello();
    }

    @Transactional
    public void hello() {
        {
            StringBuilder query = new StringBuilder();
            query.append("SELECT  ");
            query.append("    * ");
            query.append("FROM ");
            query.append("    sbs_subsetor ");
            query.append("WHERE ");
            query.append("    esq_id IS NOT NULL ");
            List resultList = em.createNativeQuery(query.toString()).getResultList();

        }

        {
            StringBuilder query = new StringBuilder();
            query.append("UPDATE `salute_prod`.`sbs_subsetor` ");
            query.append("SET ");
            query.append("    `sbs_descricao` = 'RECEPÇÃO 12222' ");
            query.append("WHERE ");
            query.append("    `sbs_id` = '1'; ");

            int executeUpdate = em.createNativeQuery(query.toString()).executeUpdate();
            
            System.out.println("AAAAAAAAAAAa");
        }
    }
}
