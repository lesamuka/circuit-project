package br.com.s3service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class S3ServiceTest {

    public static void main(String[] args) {
        try {
            // envio
            // S3Service.getBucket(S3Bucket.BUCKET_REKOGNITION).envia("DEV/teste.txt", novoArquivo());

            // download
            byte[] bytes = S3Service.getBucket(S3Bucket.BUCKET_REKOGNITION).carrega("carro.jpg");
            salvaImagem(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void salvaImagem(byte[] img) throws IOException {
        String caminhoSalvar = "carro.jpg";
        File file = new File(caminhoSalvar);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(img);
        bos.close();
    }

}
