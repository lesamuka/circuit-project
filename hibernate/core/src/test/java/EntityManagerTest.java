
import br.core.util.ConexaoFactory;
import br.core.util.JpaConfig;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

//@SpringApplicationConfiguration(classes = JpaConfig.class)
public class EntityManagerTest {
    
    @Autowired
    private EntityManager entityManager;

    public EntityManagerTest() {
    }

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
        EntityManager entityManager = ConexaoFactory.getEntityManagerMysql();
        System.out.println(entityManager);
        System.out.println("TESTE....");
    }
}
