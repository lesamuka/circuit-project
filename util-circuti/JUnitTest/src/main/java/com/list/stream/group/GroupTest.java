package com.list.stream.group;

import com.list.stream.Pessoa;
import com.list.stream.SexoEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupTest {

    private static List<Pessoa> pessoaList = new ArrayList<>();

    static {
        Pessoa pessoa = new Pessoa(12, SexoEnum.MALE);
        pessoaList.add(new Pessoa(15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(31, SexoEnum.FEMALE));
        pessoaList.add(new Pessoa(44, SexoEnum.MALE));
    }

    public static void main(String[] args) {
        exemplo1();
    }

    public static void exemplo1() {
        Map<SexoEnum, List<Pessoa>> collect = pessoaList.stream().collect(Collectors.groupingBy(Pessoa::getSex));
        System.out.println(collect);
    }

    public static void exemplo2() {
        Map<SexoEnum, List<String>> collect = pessoaList.stream().collect(Collectors.groupingBy(Pessoa::getSex, Collectors.mapping(Pessoa::getNome, Collectors.toList())));
        System.out.println(collect);
    }

    public static void exemplo3() {
        List<Pessoa> collect2 = pessoaList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect2);
    }

    public static void exemplo4() {
        List<Pessoa> collect3 = pessoaList.stream().filter(distinctByKey(p -> p.getIdade())).collect(Collectors.toList());
        System.out.println(collect3);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
