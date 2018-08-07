
import br.core.util.ConexaoFactory;
import br.hibernate.exemplo.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alci
 */
public class NewEmptyJUnitTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = entityManagerFactory.createEntityManager();
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("AAAAAAAAAA");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            List<Pessoa> resultList = em.createQuery("select u from Pessoa u ", Pessoa.class).getResultList();
        }

        System.out.println("NovoEmptyJUnitTest.hello()");
    }
}
