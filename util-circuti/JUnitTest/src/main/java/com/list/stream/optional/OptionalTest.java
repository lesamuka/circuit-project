package com.list.stream.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        exemplo1();
        exemplo2();
        exemplo3();
        exemplo4();
    }

    public static void exemplo1() {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        List<String> orElseGet = Optional.ofNullable(items).orElseGet(Collections::emptyList);
        System.out.println(orElseGet);
    }

    public static void exemplo2() {
        List<String> items = null;
        List<String> orElseGet = Optional.ofNullable(items).orElseGet(Collections::emptyList);
        System.out.println(orElseGet);
    }

    public static void exemplo3() {
        String item = "TESTE";
        String orElseGet = Optional.ofNullable(item).orElseGet(String::new);
        System.out.println(orElseGet);
    }

    public static void exemplo4() {
        String item = null;
        String orElseGet = Optional.ofNullable(item).orElseGet(String::new);
        System.out.println(orElseGet);
    }
}
