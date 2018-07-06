package br.core.util;

import br.com.autowired.Application;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class ConexaoAutowiredTest {

    @Autowired
    private ConexaoFactory conexaoFactory;

    @Test
    public void test() {
        EntityManager entityManager = conexaoFactory.getEntityManager();
        System.out.println(entityManager);
    }
}
