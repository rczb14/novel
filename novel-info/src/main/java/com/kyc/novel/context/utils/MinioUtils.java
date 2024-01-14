package com.kyc.novel.context.utils;

import io.minio.*;
import io.minio.http.Method;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MinioUtils {
    private MinioClient minioClient;
    private final String separator = "/|\\\\";
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public MinioUtils(String endpoint, String accessKey, String secretKey) {
        minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey).build();
    }

    /**
     * 创建bucket
     *
     * @param name 名称
     * @throws Exception 抛出异常
     */
    public void createBucket(String name) throws Exception {
        boolean b = bucketExists(name);
        if (!b) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
        }
    }

    /**
     * 移除bucket
     *
     * @param name 名称
     * @throws Exception 抛出异常
     */
    public void removeBucket(String name) throws Exception {
        boolean b = bucketExists(name);
        if (b) {
            minioClient.removeBucket(RemoveBucketArgs.builder().bucket(name).build());
        }
    }

    /**
     * 判断bucket是否存在
     *
     * @param name 名称
     * @throws Exception 抛出异常
     */
    public boolean bucketExists(String name) throws Exception {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build());
    }

    public void uploadFile(String bucketName, String filePath) throws Exception {
        String[] split = filePath.split(separator);
        String fileName = split[split.length - 1];
        minioClient.uploadObject(UploadObjectArgs.builder()
                .bucket(bucketName).object(sdf.format(new Date()) + "/" + fileName)
                .filename(filePath)
                .build());
    }

    public void uploadFile(String bucketName, File file) throws Exception {
        String fileName = file.getName();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName).object(sdf.format(new Date()) + "/" + fileName)
                .stream(new FileInputStream(file), -1, 10485760)
                .build());
    }

    public String getUrl(String bucketName, String object) throws Exception {
        return getUrlExpire(bucketName, object, -1, TimeUnit.SECONDS);
    }

    public String getUrl(String bucketName, String object, Integer expire, TimeUnit timeUnit) throws Exception {
        return getUrlExpire(bucketName, object, expire, timeUnit);
    }

    public String getUrlExpire(String bucketName, String filePath, Integer expire, TimeUnit timeUnit) throws Exception {
        GetPresignedObjectUrlArgs.Builder object = GetPresignedObjectUrlArgs.builder().bucket(bucketName)
                .object(filePath);
        if (expire >= 1) {
            object = object.expiry(expire, timeUnit);
        }
        return minioClient.getPresignedObjectUrl(object.method(Method.GET).build());
    }

    public static void main(String[] args) throws Exception {
        MinioUtils minioUtils = new MinioUtils("http://localhost:9000", "XeKbuc8cRuqzF2jnBao7", "PxHnjvp4rqMLAFunZ6c23XemDJZgedDkBPBrGYOT");
        minioUtils.createBucket("test");
        File file = new File("E:/111.txt");
        minioUtils.uploadFile("test", file);
        //minioUtils.uploadFile("E:\\111.txt");
        System.out.println("==============");
    }
}
