
//import br.heranca.model.Cadastro;
//import br.heranca.model.Ordem;
import br.heranca.model.Pessoa;
//import br.heranca.model.PessoaJuridica;
//import br.heranca.model.PessoaJuridica;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        try {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateDB");
            EntityManager em = entityManagerFactory.createEntityManager();
            {
//                Pessoa pessoa = new Pessoa();
//                pessoa.setNome("AAAAAAAAAA");
//                pessoa.setDataNascimento(new Date());
//                em.getTransaction().begin();
//                em.persist(pessoa);
//                em.getTransaction().commit();
//                List<Pessoa> resultList = em.createQuery("select u from Pessoa u ", Pessoa.class).getResultList();

//            Cadastro cadastro = new Cadastro();
//            cadastro.setPessoa(pessoa);
//            em.getTransaction().begin();
//            em.persist(cadastro);
//            em.getTransaction().commit();
//            List<Cadastro> cadastroList = em.createQuery("select u from Cadastro u ", Cadastro.class).getResultList();
            }

//        {
//            PessoaJuridica pessoaJuridica = new PessoaJuridica();
//            pessoaJuridica.setNome("BBBBBBBBBBBBB");
//            pessoaJuridica.setCnpj("23456789");
//            pessoaJuridica.setDataNascimento(new Date());
//            
//            Ordem ordem = new Ordem();
//            ordem.setPessoaJuridica(pessoaJuridica);
//            ordem.setDescricao("aaaaaaaaaaa");
//            
//            pessoaJuridica.getOrdemList().add(ordem);
//
//            em.getTransaction().begin();
//            em.persist(pessoaJuridica);
//            em.getTransaction().commit();
//            List<PessoaJuridica> resultList = em.createQuery("select u from PessoaJuridica u ", PessoaJuridica.class).getResultList();
//            System.out.println("NovoEmptyJUnitTest.hello()");
//
//            Cadastro cadastro = new Cadastro();
//            cadastro.setPessoa(pessoaJuridica);
//            em.getTransaction().begin();
//            em.persist(cadastro);
//            em.getTransaction().commit();
//            List<Cadastro> cadastroList = em.createQuery("select u from Cadastro u ", Cadastro.class).getResultList();
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
