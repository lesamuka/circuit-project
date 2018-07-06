package com.time.datatime.jsr319;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class DurationTest {

    static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        Instant dataHoraInicio = Instant.now();

        Date date = new Date();
        for (int i = 0; i < 10000; i++) {
            System.out.println("com.time.datatime.jsr319.DurationTest.main()");
        }

        Instant dataHoraFim = Instant.now();

        Duration between = Duration.between(dataHoraFim, dataHoraInicio);

        System.out.println(between);

        //format DAYS HOURS MINUTES SECONDS 
        System.out.printf("Total duration is %sdays %shrs %smin %ssec.\n", between.toDays(), between.toHours() % 24, between.toMinutes() % 60, between.getSeconds() % 60);

        //or format HOURS MINUTES SECONDS 
        System.out.printf("Or total duration is %shrs %smin %sec.\n", between.toHours(), between.toMinutes() % 60, between.getSeconds() % 60);

        //or format MINUTES SECONDS 
        System.out.printf("Or total duration is %smin %ssec.\n", between.toMinutes(), between.getSeconds() % 60);

        //or format SECONDS only 
        System.out.printf("Or total duration is %ssec.\n", between.getSeconds());
        
        
        
        


    }
}
