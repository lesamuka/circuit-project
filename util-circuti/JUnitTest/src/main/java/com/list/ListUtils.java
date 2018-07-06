package com.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListUtils<T, I> {

//    public List<I> toIdList(List<T> entidades) {
//        if (entidades == null) {
//            return null;
//        }
//        List<I> result = new ArrayList<>();
//        for (T t : entidades) {
//            Entidade e = (Entidade) t;
//            boolean add = result.add((I) e.getId());
//        }
//        return result;
//    }

    @Deprecated
    public static <T> List asList(T[] in) {
        List<T> genericList = new ArrayList<>();
        if (in != null) {
            for (T generic : in) {
                if (generic != null) {
                    genericList.add(generic);
                }
            }
        }
        return isEmpyt(genericList);
    }

    public static <T, I> List asList(T[] in, String delimitInicio, String delimitFim) {
        List<I> genericList = new ArrayList<>();
        if (in != null) {
            for (T generic : in) {
                if (generic != null) {
                    genericList.add((I) (delimitInicio + generic + delimitFim));
                }
            }
        }
        return isEmpyt(genericList);
    }

    private static <T> List isEmpyt(List<T> genericList) {
        if (genericList == null || genericList.isEmpty()) {
            return null;
        } else {
            return genericList;
        }
    }

//    public static Integer[] converterToIntegerArray(Entidade[] entidadeArray) {
//        try {
//            if (entidadeArray == null) {
//                return null;
//            }
//            List<Integer> grupoProdutoIdArrayList = new ArrayList<>();
//            List<Entidade> asList = Arrays.asList(entidadeArray);
//            for (Entidade entidade : asList) {
//                Integer integer = (Integer) entidade.getId();
//                grupoProdutoIdArrayList.add(integer);
//            }
//            return grupoProdutoIdArrayList.toArray(new Integer[grupoProdutoIdArrayList.size()]);
//        } catch (Exception e) {
//            throw e;
//        }
//    }

//    public static <T extends Entidade> List<Integer> converterEntidadeListToIdLis(List<T> list) {
//        return Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).filter(x -> x.getId() != null).map(x -> Integer.valueOf(x.getId().toString())).collect(Collectors.toList());
//    }

    public static List<String> removeStrigNull(List<String> list) {
        return Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().filter(p -> p != null && !p.trim().equals("")).collect(Collectors.toList());
    }

//    public static <T extends Entidade> List<T> removeNull(List<T> lista) {
//        return Optional.ofNullable(lista).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).collect(Collectors.toList());
//    }
//
//    public static <T extends Entidade> Integer[] converterToIntegerArray(List<T> lista) {
//        Entidade[] toArray = lista.toArray(new Entidade[lista.size()]);
//        return converterToIntegerArray(toArray);
//    }
}
