package com.intercepter;

public class LogTest {
    
    public static void main(String[] args) {
        testeLog("teste");
    }
    
    @Log
    public static void testeLog(String arg) {
        System.out.println(arg);
    }
    
}
