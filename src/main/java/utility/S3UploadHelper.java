package main.java.utility;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import main.java.constants.Constant;

import java.io.File;

public class S3UploadHelper {
    static String bucketName = Constant.S3UploadFileConstats.BUCKETNAME;

    public static AWSCredentials getCredential() {
        AWSCredentials credentials = new BasicAWSCredentials(
                Constant.S3UploadFileConstats.ACCESSKEY,
                Constant.S3UploadFileConstats.SECRETKEY
        );
        return credentials;
    }

    public static AmazonS3 createS3Client() {
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(S3UploadHelper.getCredential()))
                .withRegion(Regions.AP_SOUTH_1)
                .build();

        return s3client;
    }

    public static void uploadReportToS3Bucket(String fileObjKeyName, String filePath, String reportContent) {
        try {
            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(filePath));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(reportContent);
            request.setMetadata(metadata);
            S3UploadHelper.createS3Client().putObject(request);

        } catch (AmazonServiceException e) {
            e.printStackTrace();

        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

}



