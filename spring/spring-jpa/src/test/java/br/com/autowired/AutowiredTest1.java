//package br.com.autowired;
//
//import br.com.autowired.confiration.EventoAutomaticoProperties;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath*:testApplicationContext.xml" })
//@TransactionConfiguration(defaultRollback = true)
//@WebAppConfiguration
//@Transactional
//public class AutowiredTest1 {
//
//    @Autowired
//    private EventoAutomaticoProperties eventoAutomaticoProperties;
//
//    @Test
//    public void errorExample() throws Exception {
//        String nome = eventoAutomaticoProperties.getNome();
//        System.out.println(nome);
//    }
//}
