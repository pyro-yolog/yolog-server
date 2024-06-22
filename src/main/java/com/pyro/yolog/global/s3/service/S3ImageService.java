package com.pyro.yolog.global.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.pyro.yolog.global.s3.dto.S3ImageDto;
import com.pyro.yolog.global.s3.exception.FileDeleteFailureException;
import com.pyro.yolog.global.s3.exception.FileUploadFailureException;
import com.pyro.yolog.global.s3.exception.InvalidFileExtensionException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3ImageService {

    @Value("${cloud.aws.s3.bucket-name}")
    private String BUCKET_NAME;

    private final AmazonS3 amazonS3;

    public S3ImageDto uploadImage(MultipartFile file) {
        validateImageExtension(file.getOriginalFilename());
        return new S3ImageDto(uploadImageToS3(file));
    }

    private void validateImageExtension(String fileName) {
        int lastDotIndex = getLastDotIndex(fileName);
        String extention = fileName.substring(lastDotIndex + 1).toLowerCase();
        List<String> allowedExtentionList = Arrays.asList("jpg", "jpeg", "png", "gif");

        if (!allowedExtentionList.contains(extention)) {
            throw new InvalidFileExtensionException();
        }
    }

    private int getLastDotIndex(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            throw new InvalidFileExtensionException();
        }
        return lastDotIndex;
    }

    private String uploadImageToS3(MultipartFile file) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());
        String s3FileName = UUID.randomUUID().toString().substring(0, 10)
                + file.getOriginalFilename();
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME + "/image", s3FileName, file.getInputStream(), metadata).withCannedAcl(CannedAccessControlList.PublicRead);
            amazonS3.putObject(putObjectRequest);
        } catch (IOException e) {
            throw new FileUploadFailureException();
        }
        return amazonS3.getUrl(BUCKET_NAME, s3FileName).toString();
    }

    public void deleteImage(S3ImageDto dto) {
        String key = getKeyFromImageAddress(dto.getImageUrl());
        amazonS3.deleteObject(new DeleteObjectRequest(BUCKET_NAME, key));
    }

    private String getKeyFromImageAddress(String imageAddress){
        try{
            URL url = new URL(imageAddress);
            String decodingKey = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);
            return decodingKey.substring(1); // 맨 앞의 '/' 제거
        }catch (MalformedURLException e){
            throw new FileDeleteFailureException();
        }
    }
}
