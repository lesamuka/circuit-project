package br.com.s3service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import java.io.File;

public class S3Service {

    private AmazonS3 s3Client;

    private final S3Bucket bucket;
    
    private static final String ACCESS_KEY_ID = "AKIAJ4C4MKDSEL52LMZA";
    private static final String secret_key_id = "jm5n90zM5PxBv3BJDUn0GUK6WkXa0MBS/WmNvtCc";

    public static S3Service getBucket(S3Bucket bucket) {
        return new S3Service(bucket);
    }

    private S3Service(S3Bucket bucket) {
        this.bucket = bucket;
    }

    public void envia(File arquivo) {
        envia(arquivo.getName(), arquivo);
    }

    public void envia(String nomeArquivo, File arquivo) {
        s3Client.putObject(new PutObjectRequest(bucket.getPath(), nomeArquivo, arquivo));
    }

    public byte[] carrega(String nomeArquivo) {
        try {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(ACCESS_KEY_ID, secret_key_id);
            AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(awsCreds);            
            s3Client = AmazonS3ClientBuilder.standard().withRegion(Regiao.US_WEST_OREGON.getRegions()).withCredentials(awsStaticCredentialsProvider).build();
            S3Object object = s3Client.getObject(new GetObjectRequest(bucket.getPath(), nomeArquivo));
            return IOUtils.toByteArray(object.getObjectContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
