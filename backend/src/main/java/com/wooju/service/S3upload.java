package com.wooju.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface S3upload {
	public String upload(MultipartFile multipartFile) throws IOException;
}
