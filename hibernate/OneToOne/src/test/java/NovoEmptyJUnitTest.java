
import br.core.util.ConexaoFactory;
import br.core.util.TipoConexaoEnum;
import br.manytomany.Pessoa;
import br.manytomany.Endereco;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void hello() {
        TipoConexaoEnum mysql = TipoConexaoEnum.MYSQL;
        mysql.setPersistenceUnit("HibernateDB");
        EntityManager em = ConexaoFactory.getEntityManagerMysql();

        {
            Endereco endereco = new Endereco();
            endereco.setDescricao("RUA A");

            Pessoa pessoa = new Pessoa();
            pessoa.setNome("UM DOIS TRÊS DE OLIVEIRA QUATRO1");
            pessoa.setEndereco(endereco);
//
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();

            em.clear();
        }

        Pessoa pessoa = em.find(Pessoa.class, 4);
        System.out.println(pessoa);

    }
}
