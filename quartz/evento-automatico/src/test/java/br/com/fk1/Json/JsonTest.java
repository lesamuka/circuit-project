package br.com.fk1.Json;

import br.com.fk1.quartz.webservice.pojo.EventoAutomaticoPojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

public class JsonTest {

    @Test
    public void eventoAutomatico() throws Exception {
        try {
            
            Gson gSon=  new GsonBuilder().setDateFormat("HH:mm:ss").create();
            
            EventoAutomaticoPojo[] fromJson = gSon.fromJson("[{\"Id\":1,\"horaExecucao\":\"01:00:00 PM\"}]", EventoAutomaticoPojo[].class);
            System.out.println(fromJson);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
