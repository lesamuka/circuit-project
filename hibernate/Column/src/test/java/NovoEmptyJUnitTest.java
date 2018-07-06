
import br.column.ColumnType;
import br.column.TableTypeViw;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.EmbeddableType;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateDB");
        EntityManager em = entityManagerFactory.createEntityManager();

        {
            ColumnType columnType = new ColumnType();
            columnType.setColumnString("AAAAAAAAAAAAAAA");
            columnType.setColumnInteger(1111111);
            columnType.setColumnLong(11111111111L);
            columnType.setColumnBoolean(Boolean.FALSE);
            columnType.setColumnDataTime(new Date());
            columnType.setColumnDate(new Date());
            columnType.setColumnTime(new Date());
            columnType.setColumnBigInteger(BigInteger.ONE);
            columnType.setColumnBigDecimal(BigDecimal.ONE);
            columnType.setDuration(Duration.ofDays(1));

            em.getTransaction().begin();
            em.persist(columnType);
            em.getTransaction().commit();
        }
        {
            ColumnType columnType = em.find(ColumnType.class, 1);
            columnType.setColumnString("FFFFFFFF55FFFF8888FFFFFf");
            em.getTransaction().begin();
            em.merge(columnType);
            em.getTransaction().commit();
        }

        ColumnType find = em.find(ColumnType.class, 1);

        System.out.println(find);
//        StringBuilder query = new StringBuilder();
//        query.append("SELECT ");
//        query.append("    clm_id,  ");
//        query.append("    clm_column_string, ");
//        query.append("    clm_column_integer, ");
//        query.append("    clm_column_long, ");
//        query.append("    clm_column_boolean, ");
//        query.append("    clm_column_dataTime, ");
//        query.append("    clm_column_date, ");
//        query.append("    clm_column_time, ");
//        query.append("    clm_column_bigInteger, ");
//        query.append("    clm_column_bigDecimal, ");
//        query.append("    clm_column_version_date ");
//        query.append("FROM ");
//        query.append("    hibernate_db.clm_column ");
//        Metamodel metamodel = em.getMetamodel();
//        Set<EntityType<?>> entities = metamodel.getEntities();
//        HibernateProxyHelper.getClassWithoutInitializingProxy(aObject);
//        EntityType<?> entityType = metamodel.entity(TableTypeViw.class);
//        List<TableTypeViw> resultList = em.createNativeQuery(query.toString(), TableTypeViw.class).getResultList();
//        System.out.println(resultList.get(0).getColumnString());

    }

}
