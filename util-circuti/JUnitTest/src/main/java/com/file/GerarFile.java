package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class GerarFile {

    public static void main(String[] args) throws Exception {
            
    }

    private void putObject(String path, String nomeArquivo, File arquivo) {
        try {
            String home = System.getProperty("user.home");
            String s3local = home.concat("/").concat(path).concat("/").concat(nomeArquivo);
            byte[] bytes = getBytes(arquivo);
            java.io.File file = new java.io.File(s3local);
            FileOutputStream in = new FileOutputStream(file);
            in.write(bytes);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] getObject(String path, String nomeArquivo) {
        String home = System.getProperty("user.home");
        String s3local = home.concat("/").concat(path).concat("/").concat(nomeArquivo);
        File file = new File(s3local);
        return getBytes(file);
    }

    public byte[] getBytes(File file) {
        try {
            int len = (int) file.length();
            byte[] sendBuf = new byte[len];
            FileInputStream inFile = new FileInputStream(file);
            inFile.read(sendBuf, 0, len);
            return sendBuf;
        } catch (Exception e) {
            return null;
        }
    }
}

