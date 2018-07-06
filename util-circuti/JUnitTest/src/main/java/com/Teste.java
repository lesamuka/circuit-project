package com;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author alci
 */
public class Teste {

    public static void main(String[] args) {

        Integer[] integerArray = {1,2,3};
        
        atHourAndMinuteOnGivenDaysOfWeek(1, 1, integerArray);
    }

    public static void atHourAndMinuteOnGivenDaysOfWeek(int hour, int minute, Integer[] daysOfWeek) {
        String join = StringUtils.join(daysOfWeek, ",");
        String cronExpression = String.format("0 %d %d ? * %s", minute, hour, join);
        System.out.println(cronExpression);
    }
}
