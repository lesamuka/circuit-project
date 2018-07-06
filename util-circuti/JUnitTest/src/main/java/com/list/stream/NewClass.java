package com.list.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewClass {

    public static void main(String[] args) {
        listList();
    }

    public static void listList() {

        List<Pessoa> pessoaList = new ArrayList();
        pessoaList.add(new Pessoa(null, "A", 12, SexoEnum.MALE, Arrays.asList(new Contato[]{new Contato("TELEFONE", "(12)564564"), new Contato("TELEFONE", "(12)56464545")})));
        pessoaList.add(new Pessoa(null, "A", 12, SexoEnum.MALE, Arrays.asList(new Contato[]{new Contato("TELEFONE", "(12)564564"), new Contato("TELEFONE", "(12)56464545")})));
        pessoaList.add(new Pessoa(null, "A", 12, SexoEnum.MALE, Arrays.asList(new Contato[]{new Contato("TELEFONE", "(12)564564"), new Contato("TELEFONE", "(12)56464545")})));
        pessoaList.add(new Pessoa(null, "A", 12, SexoEnum.MALE, Arrays.asList(new Contato[]{new Contato("TELEFONE", "(12)564564"), new Contato("TELEFONE", "(12)56464545")})));

        List<Contato> collect = pessoaList.stream().map(doc -> doc.getContatoList()).flatMap(List::stream).collect(Collectors.toList());

//        ProcediemtnoUnico list = null;
//        List<List<ProcedimentoConcomitante>> procedimentoConcomitanteList = null;
//
//        List<ProcediemtnoUnico, List<ProcedimentoEtapaAtendimento>> list = lista.stream().find(list).or(count > 1).group().colletr(Colltores.asList());
//
//        lista.stream().find(procedimentoConcomitanteList);
        System.out.println(collect);
    }

    public static void isPresent() {
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(new Pessoa(null, "A", 12, SexoEnum.MALE));
        pessoaList.add(new Pessoa(null, "B", 15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(4, "C", 31, SexoEnum.FEMALE));
        pessoaList.add(new Pessoa(6, "D", 44, SexoEnum.MALE));

        boolean present = pessoaList.stream()
                .filter(e -> e.getSex().equals(SexoEnum.FEMALE))
                .findAny().isPresent();

        System.out.println(present);
    }

    public static void converterIntegerArrayToIntegerListIsNotNull() {
        Integer[] stringArray = {1, null, 3};

        List<Integer> orElseGet = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(Objects::nonNull).collect(Collectors.toList()))).orElseGet(Collections::emptyList);

        System.out.println(orElseGet);
    }

    public static void ofNullable() {

        List<Pessoa> pessoaList = new ArrayList<Pessoa>();
//        pessoaList.add(new Pessoa(null, "A", 12, SexoEnum.MALE));
//        pessoaList.add(new Pessoa(null, "B", 15, SexoEnum.MALE));
//        pessoaList.add(new Pessoa(4, "C", 31, SexoEnum.FEMALE));
//        pessoaList.add(new Pessoa(6, "D", 44, SexoEnum.MALE));

        List<Pessoa> collect = Optional.ofNullable(pessoaList).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).collect(Collectors.toList());

        System.out.println(collect);

    }

    public static void converterToArrayId() {
        String[] stringArray = null;

        List<String> asList = Arrays.asList(stringArray);

        List<Pessoa> pessoaList = new ArrayList<Pessoa>();
        pessoaList.add(new Pessoa(null, "A", 12, SexoEnum.MALE));
        pessoaList.add(new Pessoa(null, "B", 15, SexoEnum.MALE));
        pessoaList.add(new Pessoa(4, "C", 31, SexoEnum.FEMALE));
        pessoaList.add(new Pessoa(6, "D", 44, SexoEnum.MALE));

        Integer[] toArray = Optional.ofNullable(pessoaList).orElseGet(Collections::emptyList).stream().map(x -> x.getId()).filter(Objects::nonNull).toArray(Integer[]::new);

        System.out.println(toArray);

    }

    public static void list(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add(null);
//        list.add(null);
//        list.add(null);

        List<Integer> collect = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).collect(Collectors.toList());

//        List<Integer> collect = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
//        
        System.out.println(collect);
    }

    public static void hasMap() {
        //saldoProdutoMovimentacaoList.stream().collect(Collectors.toMap(SaldoProdutoMovimentacao::getId, item -> item));
    }

    public static void array(String[] args) {
        String[] stringArray = {"", null, "11"};

        String[] orElse = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null && !p.trim().equals("")).toArray(String[]::new))).orElse(new String[]{});

        System.out.println(orElse);

        //String[] toArray = Arrays.asList(stringArray).stream().filter(p -> p != null).toArray(size -> new String[size]);
        //String[] orElse = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null).toArray(size -> new String[size]))).orElse(new String[]{});
        Optional<Object[]> get = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null).toArray()));
        //if (get.isPresent()) {
        //    Arrays.asList(get).stream().forEach(System.out::println);
        //}
        System.out.println(get);
    }

    public static void soma(String[] args) {
        List<Pessoa> listaPessoas = Arrays.asList(new Pessoa("Joao", 32),
                new Pessoa("Antonio", 20),
                new Pessoa("Maria", 18),
                new Pessoa("Angela", 30));

        Stream<Pessoa> streamPessoas = listaPessoas.stream();

        Integer somaIdade = streamPessoas.mapToInt(p -> p.getIdade()).sum();
        long count = streamPessoas.mapToInt(p -> p.getIdade()).count();
    }
}
