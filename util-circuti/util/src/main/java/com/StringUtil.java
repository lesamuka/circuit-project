package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil extends org.apache.commons.lang3.StringUtils {

    public static String joinIsNotNull(String[] stringArray, String separator, String delimitadorInicio, String delimitadorFim) {
        List<String> list = Arrays.asList(stringArray);
        return list.stream().map(x -> (x != null) ? delimitadorInicio + x.trim() + delimitadorFim : null).filter(p -> p != null).collect(Collectors.joining(separator));
    }

    public static String joinIsNotEmptyNull(List<String> list, String separator, String delimitadorInicio, String delimitadorFim) {
        return list.stream().map(x -> (x != null) ? delimitadorInicio + x + delimitadorFim : null).filter(p -> p != null).collect(Collectors.joining(separator));
    }
}
