package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sravan")
@Component
public class UnZipProperties {
	private String zipFilePath;
	
	private String extractDir;
	
	public String getZipFilePath() {
		return zipFilePath;
	}

	public void setZipFilePath(String zipFilePath) {
		this.zipFilePath = zipFilePath;
	}

	public String getExtractDir() {
		return extractDir;
	}

	public void setExtractDir(String extractDir) {
		this.extractDir = extractDir;
	}	
}