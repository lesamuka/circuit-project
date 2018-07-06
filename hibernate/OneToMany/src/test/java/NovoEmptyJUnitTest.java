
import br.core.util.ConexaoFactory;
import br.core.util.TipoConexaoEnum;
import br.onetomany.NotaFiscal;
import br.onetomany.Produto;
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

    @Test
    public void hello() {
        TipoConexaoEnum mysql = TipoConexaoEnum.MYSQL;
        mysql.setPersistenceUnit("HibernateDB");
        EntityManager em = ConexaoFactory.getEntityManagerMysql();

        try {
            
            NotaFiscal notaFiscal = new NotaFiscal();
            notaFiscal.setNumeroNota(123);

            Produto produto = new Produto();
            produto.setDescricao("PRODUTO A");
            produto.setNotaFiscal(notaFiscal);
            notaFiscal.getProdutoList().add(produto);

            em.getTransaction().begin();
            em.persist(notaFiscal);
            em.getTransaction().commit();

            em.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        NotaFiscal fornecedor = em.find(NotaFiscal.class, 12);
        System.out.println(fornecedor);

    }
}
