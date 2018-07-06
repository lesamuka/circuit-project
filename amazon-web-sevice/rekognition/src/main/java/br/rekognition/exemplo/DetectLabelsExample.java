package br.rekognition.exemplo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.AmazonRekognitionException;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.rekognition.model.S3Object;
//import com.amazonaws.services.rekognition.model.S3Object;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class DetectLabelsExample {

    private static final String ACCESS_KEY_ID = "AKIAJ4C4MKDSEL52LMZA";
    private static final String secret_key_id = "jm5n90zM5PxBv3BJDUn0GUK6WkXa0MBS/WmNvtCc";

    private static final String PHOTO = "carro.jpg";
    private static final String BUCKET = "s3-rekognition";

//    public static void main(String[] args) throws Exception {
//        String photo = "/tmp/carro.jpg";
//
//        BasicAWSCredentials awsCreds = new BasicAWSCredentials(ACCESS_KEY_ID, secret_key_id);
//        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(awsCreds);
//
//        ByteBuffer imageBytes;
//        try (InputStream inputStream = new FileInputStream(new File(photo))) {
//            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
//        }
//
//        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
//                .standard()
//                .withRegion(Regions.US_WEST_2)
//                .withCredentials(awsStaticCredentialsProvider)
//                .build();
//
//        DetectLabelsRequest request = new DetectLabelsRequest()
//                .withImage(new Image()
//                        .withBytes(imageBytes))
//                .withMaxLabels(10)
//                .withMinConfidence(77F);
//
//        try {
//
//            DetectLabelsResult result = rekognitionClient.detectLabels(request);
//            List<Label> labels = result.getLabels();
//
//            System.out.println("Detected labels for " + photo);
//            for (Label label : labels) {
//                System.out.println(label.getName() + ": " + label.getConfidence().toString());
//            }
//
//        } catch (AmazonRekognitionException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) throws Exception {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(ACCESS_KEY_ID, secret_key_id);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(awsCreds);

        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(awsStaticCredentialsProvider)
                .build();

        DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image().withS3Object(new S3Object().withName(PHOTO).withBucket(BUCKET)))
                .withMaxLabels(10)
                .withMinConfidence(77F);

        try {

            DetectLabelsResult result = rekognitionClient.detectLabels(request);
            List<Label> labels = result.getLabels();

            System.out.println("Detected labels for " + PHOTO);
            for (Label label : labels) {
                System.out.println(label.getName() + ": " + label.getConfidence().toString());
            }

        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        }
    }
}
