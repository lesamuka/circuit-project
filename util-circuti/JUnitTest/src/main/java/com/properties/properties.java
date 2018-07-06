package com.properties;

import java.util.Properties;

public class properties {

    //java -DPROMPT=%PROMPT% Programa
    public static void main(String[] args) {
        String property = System.getProperty("PROMPT");
        
        
        Properties p = System.getProperties();
        p.list(System.out);
    }


}
