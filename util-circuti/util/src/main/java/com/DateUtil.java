package com;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DateUtil {

    public static String joinIsNotNull(Date[] array, String separator, String delimitador) {
        List<Date> asList = Arrays.asList(array);
        return asList.stream().map(x -> (x != null) ? delimitador + x + delimitador : null).filter(Objects::nonNull).collect(Collectors.joining(separator));
    }
}
