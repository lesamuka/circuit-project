package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerUtil {

    public static String joinIsNotNull(List<Integer> array, String separator, String delimitador) {
        return array.stream().map(x -> (x != null) ? delimitador + x + delimitador : null).filter(p -> p != null).collect(Collectors.joining(separator));
    }

    public static String joinIsNotNull(Integer[] array, String separator, String delimitador) {
        List<Integer> asList = Arrays.asList(array);
        return asList.stream().map(x -> (x != null) ? delimitador + x + delimitador : null).filter(p -> p != null).collect(Collectors.joining(separator));
    }
}