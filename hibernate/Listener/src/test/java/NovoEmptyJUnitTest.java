
import br.core.util.ConexaoFactory;
import br.pessoa.model.Pessoa;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NovoEmptyJUnitTest {

    public NovoEmptyJUnitTest() {
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

//    @Test
    public void hello() {
        EntityManager em = ConexaoFactory.getEntityManagerMysql();

        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("TESTE NOME");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        }
    }
}
