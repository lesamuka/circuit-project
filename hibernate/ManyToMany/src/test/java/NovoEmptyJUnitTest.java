
import br.core.util.ConexaoFactory;
import br.core.util.TipoConexaoEnum;
import br.manytomany.Atendimento;
import br.manytomany.ProblemaUsuario;
import br.manytomany.Usuario;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NovoEmptyJUnitTest {

    private static EntityManager em;

    public NovoEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        TipoConexaoEnum mysql = TipoConexaoEnum.MYSQL;
        mysql.setPersistenceUnit("HibernateDBB");
        em = ConexaoFactory.getEntityManager(mysql);
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
//    public void exemplo1() {
//        Integer atendimentoId;
//        {
//            Usuario usuario = new Usuario();
//            usuario.setNome("Teste");
//
//            ProblemaUsuario problemaUsuario = new ProblemaUsuario();
//            problemaUsuario.setUsuario(usuario);
//
//            Atendimento atendimento = new Atendimento();
//            atendimento.setUsuario(usuario);
//
//            em.getTransaction().begin();
//            em.persist(atendimento);
//            em.getTransaction().commit();
//            
//            atendimentoId = atendimento.getId();
//
//            em.clear();
//        }
//
//        Atendimento atendimento = em.find(Atendimento.class, atendimentoId);
//        System.out.println(atendimento);
//    }
//    @Test
//    public void exemplo2() {
//        {
//            Usuario usuario = new Usuario();
//            usuario.setNome("Teste");
//            
//            ProblemaUsuario problemaUsuario = new ProblemaUsuario();
//            problemaUsuario.setUsuario(usuario);
//            usuario.getProblemaUsuarioList().add(problemaUsuario);
//            
//            Atendimento atendimento = new Atendimento();
//            atendimento.setUsuario(usuario);
//
//            em.getTransaction().begin();
//            em.persist(atendimento);
//            em.getTransaction().commit();
//
//            em.clear();
//        }
//
//        Atendimento atendimento = em.find(Atendimento.class, 1);
//        System.out.println(atendimento);
//    }
    @Test
    public void exemplo3() {
        
        Integer atendimentoId;
        {
            Usuario usuario = em.find(Usuario.class, 1);

            ProblemaUsuario problemaUsuario = new ProblemaUsuario();
            problemaUsuario.setUsuario(usuario);
            usuario.getProblemaUsuarioList().add(problemaUsuario);

            Atendimento atendimento = new Atendimento();
            atendimento.setUsuario(usuario);

            em.getTransaction().begin();
            em.persist(atendimento);
            em.getTransaction().commit();

            atendimentoId = atendimento.getId();
            
            em.clear();
        }

        Atendimento atendimento = em.find(Atendimento.class, atendimentoId);
        System.out.println(atendimento);
    }
//    
//    @Test
//    public void exemplo4() {
//        Integer atendimentoId;
//        
//        {
//            Usuario usuario = em.find(Usuario.class, 1);
//            usuario.setNome("testttt");
//            
//            em.getTransaction().begin();
//            em.merge(usuario);
//            em.getTransaction().commit();
//            
//            ProblemaUsuario problemaUsuario = new ProblemaUsuario();
//            problemaUsuario.setUsuario(usuario);
//            usuario.getProblemaUsuarioList().add(problemaUsuario);
//
//            Atendimento atendimento = new Atendimento();
//            atendimento.setUsuario(usuario);
//            atendimento.getProblemaUsuarioList().add(problemaUsuario);
//
//            em.getTransaction().begin();
//            em.persist(atendimento);
//            em.getTransaction().commit();
//
//            atendimentoId = atendimento.getId();
//            
//            em.clear();
//        }
//
//        Atendimento atendimento = em.find(Atendimento.class, atendimentoId);
//        System.out.println(atendimento);
//    }
//    @Test
//    public void exemplo5() {
//
//        {
//            Atendimento atendimento = em.find(Atendimento.class, 1);
//
//            em.getTransaction().begin();
//            em.merge(atendimento.getUsuario());
//            em.getTransaction().commit();
//
//            ProblemaUsuario problemaUsuario = new ProblemaUsuario();
//            problemaUsuario.setUsuario(atendimento.getUsuario());
//            atendimento.getUsuario().getProblemaUsuarioList().add(problemaUsuario);
//
//            atendimento.getProblemaUsuarioList().add(problemaUsuario);
//
//            em.getTransaction().begin();
//            em.merge(atendimento);
//            em.getTransaction().commit();
//
//            em.clear();
//        }
//
//        Atendimento atendimento = em.find(Atendimento.class, 1);
//        System.out.println(atendimento);
//    }
//    @Test
//    public void exemplo6() {
//        Integer atendimentoId;
//        {
//
//            {
//                Usuario usuario = new Usuario();
//                usuario.setNome("Teste");
//
//                em.getTransaction().begin();
//                em.merge(usuario);
//                em.getTransaction().commit();
//                em.clear();
//            }
//
//            Atendimento atendimento = new Atendimento();
//            ProblemaUsuario problemaUsuario = new ProblemaUsuario();
//
//            {
//                Usuario usuario = em.find(Usuario.class, 1);
//                usuario.setNome("Teste2");
//
//                
//                problemaUsuario.setUsuario(usuario);
//                usuario.getProblemaUsuarioList().add(problemaUsuario);
//
//                em.getTransaction().begin();
//                em.merge(usuario);
//                em.getTransaction().commit();
//
////                em.clear();
//                
//                for (ProblemaUsuario problemaUsuario1 : usuario.getProblemaUsuarioList()) {
//                    problemaUsuario1.setAtendimento(atendimento);
//                }
//                
//                atendimento.setUsuario(usuario);
//                
//            }
//
//            {
//
//                
//                Usuario usuario = em.find(Usuario.class, atendimento.getUsuario().getId());
//                atendimento.setUsuario(usuario);
//                atendimento.getProblemaUsuarioList().add(problemaUsuario);
//
//                em.getTransaction().begin();
//                em.persist(atendimento);
//                em.getTransaction().commit();
//
//                atendimentoId = atendimento.getId();
//
//                em.clear();
//            }
//        }
//
//        Atendimento atendimento = em.find(Atendimento.class, atendimentoId);
//        System.out.println(atendimento);
//    }
//    @Test
//    public void exemplo7() {
//        Integer atendimentoId;
//        {
//
//            Atendimento atendimento = em.find(Atendimento.class, 1);
//            ProblemaUsuario problemaUsuario = new ProblemaUsuario();
//
//            {
//                Usuario usuario = em.find(Usuario.class, 1);
//                usuario.setNome("Teste2");
//
//                problemaUsuario.setUsuario(usuario);
//                usuario.getProblemaUsuarioList().add(problemaUsuario);
//
//                em.getTransaction().begin();
//                em.merge(usuario);
//                em.getTransaction().commit();
//
////                em.clear();
//                for (ProblemaUsuario problemaUsuario1 : usuario.getProblemaUsuarioList()) {
//                    problemaUsuario1.setAtendimento(atendimento);
//                    em.getTransaction().begin();
//                    problemaUsuario1 = em.merge(problemaUsuario1);
//                    em.getTransaction().commit();
//                }
//
//                atendimento.setUsuario(usuario);
//
//            }
//
//            {
//                Usuario usuario = em.find(Usuario.class, atendimento.getUsuario().getId());
//                atendimento.setUsuario(usuario);
//                atendimento.getProblemaUsuarioList().add(problemaUsuario);
//
//                em.getTransaction().begin();
//                em.merge(atendimento);
//                em.getTransaction().commit();
//
//                atendimentoId = atendimento.getId();
//
//                em.clear();
//            }
//        }
//
//        Atendimento atendimento = em.find(Atendimento.class, atendimentoId);
//        System.out.println(atendimento);
//    }
}
