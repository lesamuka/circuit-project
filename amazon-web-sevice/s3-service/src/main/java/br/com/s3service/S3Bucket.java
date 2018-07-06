package br.com.s3service;

public enum S3Bucket {

    BUCKET_REKOGNITION("s3-rekognition");

    private String path;
    
    private S3Bucket(String bucket) {
        this.path = bucket;
    }

    public String getPath() {
        return path;
    }
}
