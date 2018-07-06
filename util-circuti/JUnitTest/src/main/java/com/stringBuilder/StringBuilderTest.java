package com.stringBuilder;

import java.time.Duration;
import java.time.Instant;

public class StringBuilderTest {

    public static void main(String[] args) {
        Instant dataHoraInicio = Instant.now();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 50000000; i++) {
            stringBuilder.append("TESTO, ");
        }
        Instant dataHoraFim = Instant.now();
        Duration duration = Duration.between(dataHoraFim, dataHoraInicio);
        System.out.println("Duração " + duration);
    }

}
