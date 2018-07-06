package br.com.fk1.util;

import java.util.Map;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static String encode(Map<String, String> parameterMap) {
        try {
            List<String> parameterList = conveter(parameterMap);
            String whereString = StringUtils.join(parameterList, "&");
            return whereString;
        } catch (Exception ex) {
            return null;
        }
    }

    private static List<String> conveter(Map<String, String> params) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : params.entrySet()) {
            String converter = converter(entrySet);
            list.add(converter);
        }
        return list;
    }

    private static String converter(Map.Entry<String, String> entrySet) {
        String parameter = entrySet.getKey() + "=" + entrySet.getValue();
        return parameter;
    }
}



