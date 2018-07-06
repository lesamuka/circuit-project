package com.time.datatime.jsr319;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Beetwen {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
        System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
        System.out.println("Mes: " + localDate.getMonthValue());
        System.out.println("Mes: " + localDate.getMonth().name());
        System.out.println("Ano: " + localDate.getYear());

        Period between = Period.between(LocalDate.of(1988, Month.SEPTEMBER, 05), LocalDate.now());
        int anos = between.getDays();
        
        diferencaEntreDatas();

    }

    public static void diferencaEntreDatas() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
        System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
        System.out.println("Mes: " + localDate.getMonthValue());
        System.out.println("Mes: " + localDate.getMonth().name());
        System.out.println("Ano: " + localDate.getYear());

        Period between = Period.between(LocalDate.of(1988, Month.SEPTEMBER, 05), LocalDate.now());
        int anos = between.getDays();

        // Cria um Objeto LocalDate com a data atual.
        LocalDate hoje = LocalDate.now();

        // Cria um Objeto LocalDate com a data 26/09/2020.
        LocalDate outraData = LocalDate.of(2020, Month.SEPTEMBER, 26);

        // Calcula a diferença de dias entre as duas datas
        long diferencaEmDias = ChronoUnit.DAYS.between(hoje, outraData);
        
         // Calcula a diferença de dias entre as duas datas
        long diferencaEmSemanas = ChronoUnit.WEEKS.between(hoje, outraData);
        long until = hoje.until(outraData, ChronoUnit.WEEKS);
        
        // Calcula a diferença de meses entre as duas datas
        long diferencaEmMes = ChronoUnit.MONTHS.between(hoje, outraData);
        
        
        // Calcula a diferença de anos entre as duas datas
        long diferencaEmAnos = ChronoUnit.YEARS.between(hoje, outraData);

        // Exibe a diferença em dias entre as datas
        System.out.println("Diferença em dias entre " + hoje + " e " + outraData + " = " + diferencaEmDias);
         // Exibe a diferença em dias entre as datas
        System.out.println("Diferença em dias entre " + hoje + " e " + outraData + " = " + diferencaEmSemanas);
        // Exibe a diferença em meses entre as datas
        System.out.println("Diferença em meses entre " + hoje + " e " + outraData + " = " + diferencaEmMes);
        // Exibe a diferença em anos entre as datas
        System.out.println("Diferença em anos entre " + hoje + " e " + outraData + " = " + diferencaEmAnos);

    }
}
