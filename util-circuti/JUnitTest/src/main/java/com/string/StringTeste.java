package com.string;

import java.text.Normalizer;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class StringTeste {

    public static void main(String[] args) {
        joinString();
    }

    //[AAAAAAA, BBBBBBB, CCCCCC]
    public static String joinString() {
        List<String> list = new ArrayList();
        list.add("AAAAAAA");
        list.add("BBBBBBB");
        list.add("CCCCCC");
        return list.toString();
    }

    public static void somarConcat() {
        Instant dataHoraInicio = Instant.now();

        String string = new String();
        for (int i = 0; i < 100000; i++) {
            string = string.concat("TEXTO, ");
        }

        Instant dataHoraFim = Instant.now();
        Duration duration = Duration.between(dataHoraFim, dataHoraInicio);
        System.out.println("Duração " + duration);
    }

    public static void somarString() {
        Instant dataHoraInicio = Instant.now();
        String string = new String();
        for (int i = 0; i < 100000; i++) {
            string = string + "TESTO, ";
        }
        Instant dataHoraFim = Instant.now();
        Duration duration = Duration.between(dataHoraFim, dataHoraInicio);
        System.out.println("Duração " + duration);
    }

    public static void startsWith() {
        boolean startsWith = "2515".startsWith("12515");
        System.out.println(startsWith);
    }

    public static void split(String[] args) {
        String a = "1,2,3 ,4,5,6";
        String[] split = a.split(",");
        System.out.println(split);
    }

    public static void normalizer(String[] args) {
        String str = "maçã";
        String replaceAll = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        System.err.println(replaceAll);
    }

    public static void mainJoin(String[] args) {
        List<Integer> asList = Arrays.asList(0, 1, 2, 3);
        String join = StringUtils.join(asList, "|");
        System.out.println(join); //0|1|2|3
    }

}
