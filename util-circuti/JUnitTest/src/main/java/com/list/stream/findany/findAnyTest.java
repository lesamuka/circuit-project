package com.list.stream.findany;

import com.list.stream.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class findAnyTest {

    private static List<Pessoa> pessoaList = new ArrayList<Pessoa>();

    static {
        pessoaList.add(new Pessoa(1, "", 12, SexoEnum.MALE));
        pessoaList.add(new Pessoa(2, "", 15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(3, "", 31, SexoEnum.FEMALE));
        pessoaList.add(new Pessoa(4, "", 44, SexoEnum.MALE));
    }

    public static void main(String[] args) {
        orElseGet();
    }

    public static void orElseGet() {
        Predicate<Pessoa> predicate = new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa t) {
                return t.getId().equals(11);
            }
        };

        Pessoa pessoa = pessoaList.stream().filter(predicate).findAny().orElseGet(new Supplier<Pessoa>() {
            @Override
            public Pessoa get() {
                return new Pessoa(10, SexoEnum.MALE);
            }
        });

        System.out.println(pessoa);
    }

}
