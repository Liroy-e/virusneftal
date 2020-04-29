package com.example.upload;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

public class AvService {

    public static String checkFile(String shaHash) throws IOException, URISyntaxException {
		String reports = VirusTotal.scan(shaHash);


    return reports;
    }

    public static String getFileHash(MultipartFile file) throws IOException {
      byte[] data = file.getBytes();

      String sha256Hex = DigestUtils.sha256Hex(data);
      return sha256Hex;
    }
    
}
