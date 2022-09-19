package com.wooju.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3uploadImpl implements S3upload{
	
	 @Value("${cloud.aws.s3.bucket}")
	 private String bucket;
	 
	@Autowired
	AmazonS3 amazonS3;

	@Override
	public String upload(MultipartFile multipartFile) throws IOException {
		 String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

	        ObjectMetadata objMeta = new ObjectMetadata();
	        objMeta.setContentLength(multipartFile.getInputStream().available());

	        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);

	        return amazonS3.getUrl(bucket, s3FileName).toString();
	}
	
}
