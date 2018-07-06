package com.time.datatime.jsr319;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalDateTimeTest {
    
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
    }
    

    public static void teste(String[] args) throws InterruptedException {

        ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");

        LocalDateTime saidaDeSaoPauloSemFusoHorario = LocalDateTime.now();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000l);
        }
        LocalDateTime chegadaEmNovaYorkSemFusoHorario = LocalDateTime.now();

        ZonedDateTime saidaDeSaoPauloComFusoHorario = ZonedDateTime.of(saidaDeSaoPauloSemFusoHorario, fusoHorarioDeSaoPaulo);
        System.out.println(saidaDeSaoPauloComFusoHorario); //2014-04-04T22:30-03:00[America/Sao_Paulo]

        ZonedDateTime chegadaEmNovaYorkComFusoHorario = ZonedDateTime.of(chegadaEmNovaYorkSemFusoHorario, fusoHorarioDeSaoPaulo);
        System.out.println(chegadaEmNovaYorkComFusoHorario); //2014-04-05T07:10-04:00[America/New_York]

        Duration duracaoDoVoo = Duration.between(saidaDeSaoPauloComFusoHorario, chegadaEmNovaYorkComFusoHorario);
        System.out.println(duracaoDoVoo); //PT9H40M

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
        agora.format(formatador); //08/04/14 10:02

    }
}
